package com.iamworks.backend.dto;

import java.util.List;

public record HomeResponse(
        Brand brand,
        List<NavigationItem> navigation,
        Hero hero,
        List<ProductCardResponse> newCollection,
        Footer footer) {

    public record Brand(String name, String tagline, String description) {
    }

    public record NavigationItem(String label, String href) {
    }

    public record Hero(
            String eyebrow,
            String title,
            String scriptText,
            String description,
            String ctaLabel,
            String ctaHref,
            String image,
            List<Feature> features) {
    }

    public record Feature(String title, String description) {
    }

    public record Footer(
            String description,
            List<Social> socials,
            List<Column> columns,
            String newsletterText,
            String copyright) {
    }

    public record Social(String label, String href) {
    }

    public record Column(String title, List<Link> links) {
    }

    public record Link(String label, String href) {
    }
}
