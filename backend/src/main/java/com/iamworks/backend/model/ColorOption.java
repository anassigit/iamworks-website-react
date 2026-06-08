package com.iamworks.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ColorOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String hex;

    @Column(nullable = false)
    private Integer sortOrder;

    protected ColorOption() {
    }

    public ColorOption(String name, String hex, Integer sortOrder) {
        this.name = name;
        this.hex = hex;
        this.sortOrder = sortOrder;
    }

    public String getName() { return name; }
    public String getHex() { return hex; }
    public Integer getSortOrder() { return sortOrder; }
}
