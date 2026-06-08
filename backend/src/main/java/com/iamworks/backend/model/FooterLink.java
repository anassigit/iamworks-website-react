package com.iamworks.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class FooterLink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "column_id")
    private FooterColumn columnRef;

    @Column(nullable = false)
    private String label;

    @Column(nullable = false)
    private String href;

    @Column(nullable = false)
    private Integer sortOrder;

    protected FooterLink() {
    }

    public FooterLink(FooterColumn columnRef, String label, String href, Integer sortOrder) {
        this.columnRef = columnRef;
        this.label = label;
        this.href = href;
        this.sortOrder = sortOrder;
    }

    public FooterColumn getColumnRef() { return columnRef; }
    public String getLabel() { return label; }
    public String getHref() { return href; }
    public Integer getSortOrder() { return sortOrder; }
}
