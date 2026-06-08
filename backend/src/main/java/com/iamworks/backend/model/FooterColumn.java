package com.iamworks.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FooterColumn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Integer sortOrder;

    protected FooterColumn() {
    }

    public FooterColumn(String title, Integer sortOrder) {
        this.title = title;
        this.sortOrder = sortOrder;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public Integer getSortOrder() { return sortOrder; }
}
