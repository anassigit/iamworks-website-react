package com.iamworks.backend.dto;

public record AboutResponse(
        String title,
        String accentTitle,
        String description,
        String scriptText,
        String ctaLabel,
        String heroImage) {
}
