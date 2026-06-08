package com.iamworks.backend.config;

import java.util.List;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableConfigurationProperties(CorsConfig.CorsProperties.class)
public class CorsConfig implements WebMvcConfigurer {

    private final CorsProperties corsProperties;

    public CorsConfig(CorsProperties corsProperties) {
        this.corsProperties = corsProperties;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOriginPatterns(corsProperties.allowedOriginPatterns().toArray(String[]::new))
                .allowedMethods("GET", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(false);
    }

    @ConfigurationProperties(prefix = "app.cors")
    public record CorsProperties(List<String> allowedOriginPatterns) {
    }
}
