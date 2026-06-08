package com.iamworks.backend;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.options;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class ApiEndpointsIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void homeEndpointReturnsExpectedStructure() throws Exception {
        mockMvc.perform(get("/api/home"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brand.name").value("I'AM Works"))
                .andExpect(jsonPath("$.hero.title").value("Engineered for Freedom"))
                .andExpect(jsonPath("$.newCollection[0].slug").value("neuro-hoodie"))
                .andExpect(jsonPath("$.footer.columns[0].title").value("Shop"));
    }

    @Test
    void productsEndpointReturnsCatalogFilters() throws Exception {
        mockMvc.perform(get("/api/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Shop All"))
                .andExpect(jsonPath("$.categories[0]").value("Hoodie"))
                .andExpect(jsonPath("$.filters.sizes[0]").value("S"))
                .andExpect(jsonPath("$.filters.colors[0].name").value("Off White"))
                .andExpect(jsonPath("$.products[0].series").value("Neuro"));
    }

    @Test
    void productDetailEndpointReturnsRelatedProducts() throws Exception {
        mockMvc.perform(get("/api/products/neuro-hoodie"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.slug").value("neuro-hoodie"))
                .andExpect(jsonPath("$.currency").value("IDR"))
                .andExpect(jsonPath("$.highlights[0]").value("450 GSM cotton fleece"))
                .andExpect(jsonPath("$.related.length()").value(3));
    }

    @Test
    void collectionsEndpointReturnsBloodthornCollection() throws Exception {
        mockMvc.perform(get("/api/collections"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.hero.name").value("Bloodthorn"))
                .andExpect(jsonPath("$.products[0].series").value("Bloodthorn"));
    }

    @Test
    void communityEndpointReturnsTabsAndPosts() throws Exception {
        mockMvc.perform(get("/api/community"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Community"))
                .andExpect(jsonPath("$.tabs[0]").value("Customer Gallery"))
                .andExpect(jsonPath("$.posts[0].tag").value("Customer Gallery"));
    }

    @Test
    void aboutEndpointReturnsBrandStory() throws Exception {
        mockMvc.perform(get("/api/about"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.accentTitle").value("I'AM Works"))
                .andExpect(jsonPath("$.scriptText").value("Stay Wild & Free"));
    }

    @Test
    void healthEndpointReturnsOk() throws Exception {
        mockMvc.perform(get("/api/health"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("ok"));
    }

    @Test
    void corsAllowsGitHubPagesOrigin() throws Exception {
        mockMvc.perform(options("/api/home")
                        .header("Origin", "https://anassigit.github.io")
                        .header("Access-Control-Request-Method", "GET"))
                .andExpect(status().isOk())
                .andExpect(header().string("Access-Control-Allow-Origin", "https://anassigit.github.io"));
    }

    @Test
    void corsRejectsUnexpectedOrigin() throws Exception {
        mockMvc.perform(options("/api/home")
                        .header("Origin", "https://example.com")
                        .header("Access-Control-Request-Method", "GET"))
                .andExpect(status().isForbidden())
                .andExpect(header().doesNotExist("Access-Control-Allow-Origin"));
    }
}
