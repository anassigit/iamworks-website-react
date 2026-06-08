package com.iamworks.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AboutPage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String accentTitle;

    @Column(nullable = false, length = 1200)
    private String description;

    @Column(nullable = false)
    private String scriptText;

    @Column(nullable = false)
    private String ctaLabel;

    @Column(nullable = false, length = 1200)
    private String heroImage;

    protected AboutPage() {
    }

    public AboutPage(String title, String accentTitle, String description, String scriptText, String ctaLabel, String heroImage) {
        this.title = title;
        this.accentTitle = accentTitle;
        this.description = description;
        this.scriptText = scriptText;
        this.ctaLabel = ctaLabel;
        this.heroImage = heroImage;
    }

    public String getTitle() { return title; }
    public String getAccentTitle() { return accentTitle; }
    public String getDescription() { return description; }
    public String getScriptText() { return scriptText; }
    public String getCtaLabel() { return ctaLabel; }
    public String getHeroImage() { return heroImage; }
}
