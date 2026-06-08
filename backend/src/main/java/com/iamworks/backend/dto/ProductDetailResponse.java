package com.iamworks.backend.dto;

import java.math.BigDecimal;
import java.util.List;

public record ProductDetailResponse(
        String slug,
        String name,
        BigDecimal price,
        String currency,
        BigDecimal rating,
        int reviewCount,
        String description,
        List<String> highlights,
        List<String> sizes,
        List<String> gallery,
        String series,
        String category,
        List<ProductCardResponse> related) {
}
