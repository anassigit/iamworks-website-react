package com.iamworks.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class HeroFeature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 1000)
    private String description;

    @Column(nullable = false)
    private Integer sortOrder;

    protected HeroFeature() {
    }

    public HeroFeature(String title, String description, Integer sortOrder) {
        this.title = title;
        this.description = description;
        this.sortOrder = sortOrder;
    }

    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public Integer getSortOrder() { return sortOrder; }
}
