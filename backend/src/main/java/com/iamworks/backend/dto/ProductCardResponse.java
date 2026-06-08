package com.iamworks.backend.dto;

import java.math.BigDecimal;

public record ProductCardResponse(
        String slug,
        String name,
        BigDecimal price,
        String currency,
        String image,
        String category,
        String series) {
}
