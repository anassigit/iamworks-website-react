package com.iamworks.backend.dto;

import java.util.List;

public record CollectionsResponse(Hero hero, List<ProductCardResponse> products) {

    public record Hero(
            String name,
            String title,
            String description,
            String ctaLabel,
            String image) {
    }
}
