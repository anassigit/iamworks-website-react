package com.iamworks.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class NavigationItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String label;

    @Column(nullable = false)
    private String href;

    @Column(nullable = false)
    private Integer sortOrder;

    protected NavigationItem() {
    }

    public NavigationItem(String label, String href, Integer sortOrder) {
        this.label = label;
        this.href = href;
        this.sortOrder = sortOrder;
    }

    public String getLabel() { return label; }
    public String getHref() { return href; }
    public Integer getSortOrder() { return sortOrder; }
}
