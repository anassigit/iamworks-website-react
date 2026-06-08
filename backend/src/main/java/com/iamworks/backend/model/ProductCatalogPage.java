package com.iamworks.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProductCatalogPage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 1000)
    private String summary;

    protected ProductCatalogPage() {
    }

    public ProductCatalogPage(String title, String summary) {
        this.title = title;
        this.summary = summary;
    }

    public String getTitle() { return title; }
    public String getSummary() { return summary; }
}
