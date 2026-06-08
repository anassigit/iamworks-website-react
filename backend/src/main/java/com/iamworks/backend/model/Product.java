package com.iamworks.backend.model;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OrderColumn;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String slug;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, precision = 10, scale = 0)
    private BigDecimal price;

    @Column(nullable = false)
    private String currency;

    @Column(nullable = false, length = 1200)
    private String image;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String series;

    @Column(nullable = false, precision = 2, scale = 1)
    private BigDecimal rating;

    @Column(nullable = false)
    private Integer reviewCount;

    @Column(nullable = false, length = 2000)
    private String description;

    @Column(nullable = false)
    private Boolean newCollection;

    @Column(nullable = false)
    private Integer sortOrder;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "product_highlights", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "highlight_text", nullable = false)
    @OrderColumn(name = "highlight_order")
    private List<String> highlights = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "product_sizes", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "size_label", nullable = false)
    @OrderColumn(name = "size_order")
    private List<String> sizes = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "product_gallery", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "image_url", nullable = false, length = 1200)
    @OrderColumn(name = "gallery_order")
    private List<String> gallery = new ArrayList<>();

    public Long getId() { return id; }
    public String getSlug() { return slug; }
    public void setSlug(String slug) { this.slug = slug; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }
    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getSeries() { return series; }
    public void setSeries(String series) { this.series = series; }
    public BigDecimal getRating() { return rating; }
    public void setRating(BigDecimal rating) { this.rating = rating; }
    public Integer getReviewCount() { return reviewCount; }
    public void setReviewCount(Integer reviewCount) { this.reviewCount = reviewCount; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Boolean getNewCollection() { return newCollection; }
    public void setNewCollection(Boolean newCollection) { this.newCollection = newCollection; }
    public Integer getSortOrder() { return sortOrder; }
    public void setSortOrder(Integer sortOrder) { this.sortOrder = sortOrder; }
    public List<String> getHighlights() { return highlights; }
    public void setHighlights(List<String> highlights) { this.highlights = new ArrayList<>(highlights); }
    public List<String> getSizes() { return sizes; }
    public void setSizes(List<String> sizes) { this.sizes = new ArrayList<>(sizes); }
    public List<String> getGallery() { return gallery; }
    public void setGallery(List<String> gallery) { this.gallery = new ArrayList<>(gallery); }
}
