package com.iamworks.backend.service;

import com.iamworks.backend.dto.HomeResponse;
import com.iamworks.backend.dto.ProductCardResponse;
import com.iamworks.backend.model.FooterColumn;
import com.iamworks.backend.model.HomePageContent;
import com.iamworks.backend.model.Product;
import com.iamworks.backend.repository.FooterColumnRepository;
import com.iamworks.backend.repository.FooterLinkRepository;
import com.iamworks.backend.repository.FooterSocialRepository;
import com.iamworks.backend.repository.HeroFeatureRepository;
import com.iamworks.backend.repository.HomePageContentRepository;
import com.iamworks.backend.repository.NavigationItemRepository;
import com.iamworks.backend.repository.ProductRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class HomeService {

    private final HomePageContentRepository homePageContentRepository;
    private final NavigationItemRepository navigationItemRepository;
    private final HeroFeatureRepository heroFeatureRepository;
    private final FooterSocialRepository footerSocialRepository;
    private final FooterColumnRepository footerColumnRepository;
    private final FooterLinkRepository footerLinkRepository;
    private final ProductRepository productRepository;

    public HomeService(
            HomePageContentRepository homePageContentRepository,
            NavigationItemRepository navigationItemRepository,
            HeroFeatureRepository heroFeatureRepository,
            FooterSocialRepository footerSocialRepository,
            FooterColumnRepository footerColumnRepository,
            FooterLinkRepository footerLinkRepository,
            ProductRepository productRepository) {
        this.homePageContentRepository = homePageContentRepository;
        this.navigationItemRepository = navigationItemRepository;
        this.heroFeatureRepository = heroFeatureRepository;
        this.footerSocialRepository = footerSocialRepository;
        this.footerColumnRepository = footerColumnRepository;
        this.footerLinkRepository = footerLinkRepository;
        this.productRepository = productRepository;
    }

    public HomeResponse getHome() {
        HomePageContent content = homePageContentRepository.findTopByOrderByIdAsc()
                .orElseThrow(() -> new IllegalStateException("Home page content not found"));

        return new HomeResponse(
                new HomeResponse.Brand(content.getBrandName(), content.getTagline(), content.getBrandDescription()),
                navigationItemRepository.findAllByOrderBySortOrderAsc().stream()
                        .map(item -> new HomeResponse.NavigationItem(item.getLabel(), item.getHref()))
                        .toList(),
                new HomeResponse.Hero(
                        content.getHeroEyebrow(),
                        content.getHeroTitle(),
                        content.getHeroScriptText(),
                        content.getHeroDescription(),
                        content.getHeroCtaLabel(),
                        content.getHeroCtaHref(),
                        content.getHeroImage(),
                        heroFeatureRepository.findAllByOrderBySortOrderAsc().stream()
                                .map(feature -> new HomeResponse.Feature(feature.getTitle(), feature.getDescription()))
                                .toList()),
                productRepository.findByNewCollectionTrueOrderBySortOrderAsc().stream()
                        .map(this::toProductCard)
                        .toList(),
                new HomeResponse.Footer(
                        content.getFooterDescription(),
                        footerSocialRepository.findAllByOrderBySortOrderAsc().stream()
                                .map(social -> new HomeResponse.Social(social.getLabel(), social.getHref()))
                                .toList(),
                        footerColumnRepository.findAllByOrderBySortOrderAsc().stream()
                                .map(this::toFooterColumn)
                                .toList(),
                        content.getNewsletterText(),
                        content.getCopyrightText())
        );
    }

    private HomeResponse.Column toFooterColumn(FooterColumn column) {
        List<HomeResponse.Link> links = footerLinkRepository.findByColumnRefOrderBySortOrderAsc(column).stream()
                .map(link -> new HomeResponse.Link(link.getLabel(), link.getHref()))
                .toList();
        return new HomeResponse.Column(column.getTitle(), links);
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
