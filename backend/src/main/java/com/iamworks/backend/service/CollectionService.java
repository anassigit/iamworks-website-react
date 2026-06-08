package com.iamworks.backend.service;

import com.iamworks.backend.dto.CollectionsResponse;
import com.iamworks.backend.dto.ProductCardResponse;
import com.iamworks.backend.model.CollectionHero;
import com.iamworks.backend.model.Product;
import com.iamworks.backend.repository.CollectionHeroRepository;
import com.iamworks.backend.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class CollectionService {

    private final CollectionHeroRepository collectionHeroRepository;
    private final ProductRepository productRepository;

    public CollectionService(CollectionHeroRepository collectionHeroRepository, ProductRepository productRepository) {
        this.collectionHeroRepository = collectionHeroRepository;
        this.productRepository = productRepository;
    }

    public CollectionsResponse getCollections() {
        CollectionHero hero = collectionHeroRepository.findTopByOrderByIdAsc()
                .orElseThrow(() -> new IllegalStateException("Collection hero not found"));

        return new CollectionsResponse(
                new CollectionsResponse.Hero(
                        hero.getName(),
                        hero.getTitle(),
                        hero.getDescription(),
                        hero.getCtaLabel(),
                        hero.getImage()),
                productRepository.findBySeriesOrderBySortOrderAsc(hero.getName()).stream()
                        .map(this::toProductCard)
                        .toList());
    }

    private ProductCardResponse toProductCard(Product product) {
        return new ProductCardResponse(
                product.getSlug(),
                product.getName(),
                product.getPrice(),
                product.getCurrency(),
                product.getImage(),
                product.getCategory(),
                product.getSeries());
    }
}
