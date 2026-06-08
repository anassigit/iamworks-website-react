package com.iamworks.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CommunityPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 1200)
    private String image;

    @Column(nullable = false)
    private String tag;

    @Column(nullable = false)
    private Integer sortOrder;

    protected CommunityPost() {
    }

    public CommunityPost(String title, String image, String tag, Integer sortOrder) {
        this.title = title;
        this.image = image;
        this.tag = tag;
        this.sortOrder = sortOrder;
    }

    public String getTitle() { return title; }
    public String getImage() { return image; }
    public String getTag() { return tag; }
    public Integer getSortOrder() { return sortOrder; }
}
