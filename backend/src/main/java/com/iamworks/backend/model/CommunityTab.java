package com.iamworks.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CommunityTab {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String label;

    @Column(nullable = false)
    private Integer sortOrder;

    protected CommunityTab() {
    }

    public CommunityTab(String label, Integer sortOrder) {
        this.label = label;
        this.sortOrder = sortOrder;
    }

    public String getLabel() { return label; }
    public Integer getSortOrder() { return sortOrder; }
}
