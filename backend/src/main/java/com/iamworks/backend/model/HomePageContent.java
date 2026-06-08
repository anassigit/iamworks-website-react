package com.iamworks.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class HomePageContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String brandName;

    @Column(nullable = false)
    private String tagline;

    @Column(nullable = false, length = 1000)
    private String brandDescription;

    @Column(nullable = false)
    private String heroEyebrow;

    @Column(nullable = false)
    private String heroTitle;

    @Column(nullable = false)
    private String heroScriptText;

    @Column(nullable = false, length = 1200)
    private String heroDescription;

    @Column(nullable = false)
    private String heroCtaLabel;

    @Column(nullable = false)
    private String heroCtaHref;

    @Column(nullable = false, length = 1200)
    private String heroImage;

    @Column(nullable = false, length = 1000)
    private String footerDescription;

    @Column(nullable = false, length = 1000)
    private String newsletterText;

    @Column(nullable = false)
    private String copyrightText;

    protected HomePageContent() {
    }

    public HomePageContent(
            String brandName,
            String tagline,
            String brandDescription,
            String heroEyebrow,
            String heroTitle,
            String heroScriptText,
            String heroDescription,
            String heroCtaLabel,
            String heroCtaHref,
            String heroImage,
            String footerDescription,
            String newsletterText,
            String copyrightText) {
        this.brandName = brandName;
        this.tagline = tagline;
        this.brandDescription = brandDescription;
        this.heroEyebrow = heroEyebrow;
        this.heroTitle = heroTitle;
        this.heroScriptText = heroScriptText;
        this.heroDescription = heroDescription;
        this.heroCtaLabel = heroCtaLabel;
        this.heroCtaHref = heroCtaHref;
        this.heroImage = heroImage;
        this.footerDescription = footerDescription;
        this.newsletterText = newsletterText;
        this.copyrightText = copyrightText;
    }

    public Long getId() { return id; }
    public String getBrandName() { return brandName; }
    public String getTagline() { return tagline; }
    public String getBrandDescription() { return brandDescription; }
    public String getHeroEyebrow() { return heroEyebrow; }
    public String getHeroTitle() { return heroTitle; }
    public String getHeroScriptText() { return heroScriptText; }
    public String getHeroDescription() { return heroDescription; }
    public String getHeroCtaLabel() { return heroCtaLabel; }
    public String getHeroCtaHref() { return heroCtaHref; }
    public String getHeroImage() { return heroImage; }
    public String getFooterDescription() { return footerDescription; }
    public String getNewsletterText() { return newsletterText; }
    public String getCopyrightText() { return copyrightText; }
}
