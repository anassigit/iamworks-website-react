package com.iamworks.backend.dto;

import java.util.List;

public record ProductsResponse(
        String title,
        String summary,
        List<String> categories,
        Filters filters,
        List<ProductCardResponse> products) {

    public record Filters(List<String> sizes, List<ColorOption> colors, List<String> series) {
    }

    public record ColorOption(String name, String hex) {
    }
}
