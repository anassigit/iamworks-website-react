package com.iamworks.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CollectionHero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 1200)
    private String description;

    @Column(nullable = false)
    private String ctaLabel;

    @Column(nullable = false, length = 1200)
    private String image;

    protected CollectionHero() {
    }

    public CollectionHero(String name, String title, String description, String ctaLabel, String image) {
        this.name = name;
        this.title = title;
        this.description = description;
        this.ctaLabel = ctaLabel;
        this.image = image;
    }

    public String getName() { return name; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getCtaLabel() { return ctaLabel; }
    public String getImage() { return image; }
}
