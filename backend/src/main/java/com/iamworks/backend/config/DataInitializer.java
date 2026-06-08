package com.iamworks.backend.config;

import com.iamworks.backend.model.AboutPage;
import com.iamworks.backend.model.CollectionHero;
import com.iamworks.backend.model.ColorOption;
import com.iamworks.backend.model.CommunityPage;
import com.iamworks.backend.model.CommunityPost;
import com.iamworks.backend.model.CommunityTab;
import com.iamworks.backend.model.FooterColumn;
import com.iamworks.backend.model.FooterLink;
import com.iamworks.backend.model.FooterSocial;
import com.iamworks.backend.model.HeroFeature;
import com.iamworks.backend.model.HomePageContent;
import com.iamworks.backend.model.NavigationItem;
import com.iamworks.backend.model.Product;
import com.iamworks.backend.model.ProductCatalogPage;
import com.iamworks.backend.repository.AboutPageRepository;
import com.iamworks.backend.repository.CollectionHeroRepository;
import com.iamworks.backend.repository.ColorOptionRepository;
import com.iamworks.backend.repository.CommunityPageRepository;
import com.iamworks.backend.repository.CommunityPostRepository;
import com.iamworks.backend.repository.CommunityTabRepository;
import com.iamworks.backend.repository.FooterColumnRepository;
import com.iamworks.backend.repository.FooterLinkRepository;
import com.iamworks.backend.repository.FooterSocialRepository;
import com.iamworks.backend.repository.HeroFeatureRepository;
import com.iamworks.backend.repository.HomePageContentRepository;
import com.iamworks.backend.repository.NavigationItemRepository;
import com.iamworks.backend.repository.ProductCatalogPageRepository;
import com.iamworks.backend.repository.ProductRepository;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final HomePageContentRepository homePageContentRepository;
    private final NavigationItemRepository navigationItemRepository;
    private final HeroFeatureRepository heroFeatureRepository;
    private final FooterSocialRepository footerSocialRepository;
    private final FooterColumnRepository footerColumnRepository;
    private final FooterLinkRepository footerLinkRepository;
    private final ProductCatalogPageRepository productCatalogPageRepository;
    private final ColorOptionRepository colorOptionRepository;
    private final ProductRepository productRepository;
    private final CollectionHeroRepository collectionHeroRepository;
    private final CommunityPageRepository communityPageRepository;
    private final CommunityTabRepository communityTabRepository;
    private final CommunityPostRepository communityPostRepository;
    private final AboutPageRepository aboutPageRepository;

    public DataInitializer(
            HomePageContentRepository homePageContentRepository,
            NavigationItemRepository navigationItemRepository,
            HeroFeatureRepository heroFeatureRepository,
            FooterSocialRepository footerSocialRepository,
            FooterColumnRepository footerColumnRepository,
            FooterLinkRepository footerLinkRepository,
            ProductCatalogPageRepository productCatalogPageRepository,
            ColorOptionRepository colorOptionRepository,
            ProductRepository productRepository,
            CollectionHeroRepository collectionHeroRepository,
            CommunityPageRepository communityPageRepository,
            CommunityTabRepository communityTabRepository,
            CommunityPostRepository communityPostRepository,
            AboutPageRepository aboutPageRepository) {
        this.homePageContentRepository = homePageContentRepository;
        this.navigationItemRepository = navigationItemRepository;
        this.heroFeatureRepository = heroFeatureRepository;
        this.footerSocialRepository = footerSocialRepository;
        this.footerColumnRepository = footerColumnRepository;
        this.footerLinkRepository = footerLinkRepository;
        this.productCatalogPageRepository = productCatalogPageRepository;
        this.colorOptionRepository = colorOptionRepository;
        this.productRepository = productRepository;
        this.collectionHeroRepository = collectionHeroRepository;
        this.communityPageRepository = communityPageRepository;
        this.communityTabRepository = communityTabRepository;
        this.communityPostRepository = communityPostRepository;
        this.aboutPageRepository = aboutPageRepository;
    }

    @Override
    public void run(String... args) {
        if (productRepository.count() > 0) {
            return;
        }

        homePageContentRepository.save(new HomePageContent(
                "I'AM Works",
                "Stay Wild & Free",
                "Riding apparel and gear built for riders who live between custom culture, streetwear attitude, and long nights on the road.",
                "Built for the Wild Ones",
                "Engineered for Freedom",
                "Stay Wild & Free",
                "Premium riding apparel inspired by Indonesian custom motorcycle culture, premium fabrics, and everyday mobility.",
                "Shop Now",
                "/shop",
                "https://images.unsplash.com/photo-1517841905240-472988babdf9?auto=format&fit=crop&w=1400&q=80",
                "Riding apparel and gear built for the wild ones.",
                "Join our newsletter and get 10% off your first order.",
                "© 2024 I'AM Works Company. All Rights Reserved."
        ));

        navigationItemRepository.saveAll(List.of(
                navigationItem(1, "Home", "/"),
                navigationItem(2, "Shop", "/shop"),
                navigationItem(3, "Collections", "/collections"),
                navigationItem(4, "IAM Garage", "/iam-garage"),
                navigationItem(5, "Community", "/community"),
                navigationItem(6, "Journal", "/journal"),
                navigationItem(7, "About", "/about"),
                navigationItem(8, "Contact", "/contact")
        ));

        heroFeatureRepository.saveAll(List.of(
                heroFeature(1, "Premium Quality", "Built to last with heavyweight materials and durable print details."),
                heroFeature(2, "Free Shipping", "Free shipping for orders above IDR 1,000,000 across Indonesia."),
                heroFeature(3, "Easy Returns", "30-day return policy for unworn catalog products."),
                heroFeature(4, "Secure Payment", "Protected checkout with trusted local payment methods.")
        ));

        footerSocialRepository.saveAll(List.of(
                footerSocial(1, "Instagram", "https://www.instagram.com/iamworks.id"),
                footerSocial(2, "TikTok", "https://www.tiktok.com/@iamworks.id"),
                footerSocial(3, "YouTube", "https://www.youtube.com/@iamworks")
        ));

        FooterColumn shop = footerColumnRepository.save(new FooterColumn("Shop", 1));
        FooterColumn collections = footerColumnRepository.save(new FooterColumn("Collections", 2));
        FooterColumn garage = footerColumnRepository.save(new FooterColumn("IAM Garage", 3));
        FooterColumn support = footerColumnRepository.save(new FooterColumn("Support", 4));

        footerLinkRepository.saveAll(List.of(
                footerLink(shop, 1, "All Products", "/shop"),
                footerLink(shop, 2, "Hoodies", "/shop?category=Hoodie"),
                footerLink(shop, 3, "T-Shirts", "/shop?category=T-Shirt"),
                footerLink(shop, 4, "Accessories", "/shop?category=Accessories"),
                footerLink(shop, 5, "Limited Edition", "/shop?category=Limited%20Edition"),
                footerLink(collections, 1, "Bloodthorn", "/shop?series=Bloodthorn"),
                footerLink(collections, 2, "Neuro", "/shop?series=Neuro"),
                footerLink(collections, 3, "Clown Psycho", "/shop?series=Clown%20Psycho"),
                footerLink(collections, 4, "Dominus Noctis", "/shop?series=Dominus%20Noctis"),
                footerLink(collections, 5, "Black Voltage", "/shop?series=Black%20Voltage"),
                footerLink(garage, 1, "Featured Bike", "/iam-garage"),
                footerLink(garage, 2, "Builder Story", "/iam-garage"),
                footerLink(garage, 3, "Project Showcase", "/iam-garage"),
                footerLink(support, 1, "FAQ", "/support/faq"),
                footerLink(support, 2, "Shipping & Returns", "/support/shipping"),
                footerLink(support, 3, "Size Chart", "/support/size-chart"),
                footerLink(support, 4, "Contact Us", "/contact")
        ));

        productCatalogPageRepository.save(new ProductCatalogPage(
                "Shop All",
                "Curated riding apparel, premium everyday gear, and signature series inspired by I'AM Works culture."
        ));

        colorOptionRepository.saveAll(List.of(
                colorOption(1, "Off White", "#E8E8E8"),
                colorOption(2, "Olive", "#8A9A5B"),
                colorOption(3, "Accent Red", "#E53935"),
                colorOption(4, "Primary Black", "#0B0B0B")
        ));

        productRepository.saveAll(List.of(
                product(
                        1,
                        "neuro-hoodie",
                        "Neuro Hoodie",
                        689000,
                        "https://images.unsplash.com/photo-1556821840-3a63f95609a7?auto=format&fit=crop&w=900&q=80",
                        "Hoodie",
                        "Neuro",
                        4.9,
                        35,
                        "A heavyweight hoodie with premium materials and a bold back graphic inspired by neural chaos and night rides.",
                        true,
                        List.of("450 GSM cotton fleece", "Puff print front detail", "Plastisol back print", "Oversize fit", "Ribbed cuffs and hem"),
                        List.of("S", "M", "L", "XL", "XXL"),
                        List.of(
                                "https://images.unsplash.com/photo-1556821840-3a63f95609a7?auto=format&fit=crop&w=900&q=80",
                                "https://images.unsplash.com/photo-1521572163474-6864f9cf17ab?auto=format&fit=crop&w=900&q=80",
                                "https://images.unsplash.com/photo-1503341504253-dff4815485f1?auto=format&fit=crop&w=900&q=80"
                        )
                ),
                product(
                        2,
                        "bloodthorn-hoodie",
                        "Bloodthorn Hoodie",
                        699000,
                        "https://images.unsplash.com/photo-1523398002811-999ca8dec234?auto=format&fit=crop&w=900&q=80",
                        "Hoodie",
                        "Bloodthorn",
                        4.8,
                        24,
                        "Signature Bloodthorn hoodie with aggressive front-and-back artwork, tailored for cooler night rides and daily wear.",
                        true,
                        List.of("Heavy cotton fleece body", "High density chest print", "Oversized hood", "Double needle stitching"),
                        List.of("M", "L", "XL", "XXL"),
                        List.of(
                                "https://images.unsplash.com/photo-1523398002811-999ca8dec234?auto=format&fit=crop&w=900&q=80",
                                "https://images.unsplash.com/photo-1503342217505-b0a15ec3261c?auto=format&fit=crop&w=900&q=80",
                                "https://images.unsplash.com/photo-1521572267360-ee0c2909d518?auto=format&fit=crop&w=900&q=80"
                        )
                ),
                product(
                        3,
                        "clown-psycho-tshirt",
                        "Clown Psycho T-Shirt",
                        329000,
                        "https://images.unsplash.com/photo-1521572267360-ee0c2909d518?auto=format&fit=crop&w=900&q=80",
                        "T-Shirt",
                        "Clown Psycho",
                        4.7,
                        18,
                        "An oversized tee with a chaotic circus-inspired print treatment, softened premium cotton, and an easy streetwear silhouette.",
                        true,
                        List.of("240 GSM combed cotton", "Soft hand plastisol print", "Boxy streetwear fit", "Reinforced shoulder tape"),
                        List.of("S", "M", "L", "XL"),
                        List.of(
                                "https://images.unsplash.com/photo-1521572267360-ee0c2909d518?auto=format&fit=crop&w=900&q=80",
                                "https://images.unsplash.com/photo-1521572163474-6864f9cf17ab?auto=format&fit=crop&w=900&q=80",
                                "https://images.unsplash.com/photo-1583743814966-8936f5b7be1a?auto=format&fit=crop&w=900&q=80"
                        )
                ),
                product(
                        4,
                        "dominus-noctis-hoodie",
                        "Dominus Noctis Hoodie",
                        698000,
                        "https://images.unsplash.com/photo-1507679799987-c73779587ccf?auto=format&fit=crop&w=900&q=80",
                        "Hoodie",
                        "Dominus Noctis",
                        4.8,
                        21,
                        "Dark, refined, and commanding. Dominus Noctis brings a monochrome premium fit for riders who prefer understated menace.",
                        true,
                        List.of("Brushed fleece interior", "High-build tonal print", "Relaxed drop shoulder fit", "Metal tipped drawcords"),
                        List.of("M", "L", "XL", "XXL"),
                        List.of(
                                "https://images.unsplash.com/photo-1507679799987-c73779587ccf?auto=format&fit=crop&w=900&q=80",
                                "https://images.unsplash.com/photo-1503342217505-b0a15ec3261c?auto=format&fit=crop&w=900&q=80",
                                "https://images.unsplash.com/photo-1490114538077-0a7f8cb49891?auto=format&fit=crop&w=900&q=80"
                        )
                ),
                product(
                        5,
                        "black-voltage-hoodie",
                        "Black Voltage Hoodie",
                        689000,
                        "https://images.unsplash.com/photo-1490114538077-0a7f8cb49891?auto=format&fit=crop&w=900&q=80",
                        "Hoodie",
                        "Black Voltage",
                        4.6,
                        14,
                        "A stealthy blacked-out hoodie with energetic line work and reflective accents for late-night city rides.",
                        false,
                        List.of("Reflective detail accents", "Heavyweight fleece", "Large back graphic", "Oversized cut"),
                        List.of("M", "L", "XL"),
                        List.of(
                                "https://images.unsplash.com/photo-1490114538077-0a7f8cb49891?auto=format&fit=crop&w=900&q=80",
                                "https://images.unsplash.com/photo-1556821840-3a63f95609a7?auto=format&fit=crop&w=900&q=80",
                                "https://images.unsplash.com/photo-1503341504253-dff4815485f1?auto=format&fit=crop&w=900&q=80"
                        )
                ),
                product(
                        6,
                        "chrome-phantom-tshirt",
                        "Chrome Phantom T-Shirt",
                        328000,
                        "https://images.unsplash.com/photo-1583743814966-8936f5b7be1a?auto=format&fit=crop&w=900&q=80",
                        "T-Shirt",
                        "Chrome Phantom",
                        4.5,
                        11,
                        "Premium short sleeve tee with chrome-inspired artwork and a smooth drape for everyday use.",
                        false,
                        List.of("Premium 24s cotton", "Discharge print finish", "Relaxed torso width", "Soft-touch neck rib"),
                        List.of("S", "M", "L", "XL"),
                        List.of(
                                "https://images.unsplash.com/photo-1583743814966-8936f5b7be1a?auto=format&fit=crop&w=900&q=80",
                                "https://images.unsplash.com/photo-1521572163474-6864f9cf17ab?auto=format&fit=crop&w=900&q=80",
                                "https://images.unsplash.com/photo-1521572267360-ee0c2909d518?auto=format&fit=crop&w=900&q=80"
                        )
                ),
                product(
                        7,
                        "bloodthorn-crewneck",
                        "Bloodthorn Crewneck",
                        599000,
                        "https://images.unsplash.com/photo-1503342217505-b0a15ec3261c?auto=format&fit=crop&w=900&q=80",
                        "Crewneck",
                        "Bloodthorn",
                        4.7,
                        16,
                        "Clean crewneck silhouette featuring the thorn-circle Bloodthorn emblem and a brushed interior for daily comfort.",
                        false,
                        List.of("French terry interior", "Screen printed front graphic", "Relaxed fit", "Double rib finish"),
                        List.of("M", "L", "XL"),
                        List.of(
                                "https://images.unsplash.com/photo-1503342217505-b0a15ec3261c?auto=format&fit=crop&w=900&q=80",
                                "https://images.unsplash.com/photo-1523398002811-999ca8dec234?auto=format&fit=crop&w=900&q=80",
                                "https://images.unsplash.com/photo-1490114538077-0a7f8cb49891?auto=format&fit=crop&w=900&q=80"
                        )
                ),
                product(
                        8,
                        "bloodthorn-gloves",
                        "Bloodthorn Gloves",
                        399000,
                        "https://images.unsplash.com/photo-1517841905240-472988babdf9?auto=format&fit=crop&w=900&q=80",
                        "Gloves",
                        "Bloodthorn",
                        4.8,
                        9,
                        "Protective riding gloves with silicone grip zones, thorn insignia, and breathable stretch panels.",
                        false,
                        List.of("Touchscreen compatible fingertips", "Silicone palm grip", "Breathable stretch mesh", "Adjustable wrist strap"),
                        List.of("S", "M", "L", "XL"),
                        List.of(
                                "https://images.unsplash.com/photo-1517841905240-472988babdf9?auto=format&fit=crop&w=900&q=80",
                                "https://images.unsplash.com/photo-1521572163474-6864f9cf17ab?auto=format&fit=crop&w=900&q=80",
                                "https://images.unsplash.com/photo-1490114538077-0a7f8cb49891?auto=format&fit=crop&w=900&q=80"
                        )
                ),
                product(
                        9,
                        "iam-gloves-black",
                        "IAM Gloves - Black",
                        389000,
                        "https://images.unsplash.com/photo-1503341504253-dff4815485f1?auto=format&fit=crop&w=900&q=80",
                        "Gloves",
                        "Core Gear",
                        4.6,
                        13,
                        "Core riding gloves designed for daily use with slim ergonomics and a clean stealth look.",
                        false,
                        List.of("Abrasion resistant palm", "Touchscreen thumb and index", "Flexible neoprene cuff", "Secure hook-and-loop closure"),
                        List.of("S", "M", "L", "XL"),
                        List.of(
                                "https://images.unsplash.com/photo-1503341504253-dff4815485f1?auto=format&fit=crop&w=900&q=80",
                                "https://images.unsplash.com/photo-1517841905240-472988babdf9?auto=format&fit=crop&w=900&q=80",
                                "https://images.unsplash.com/photo-1521572163474-6864f9cf17ab?auto=format&fit=crop&w=900&q=80"
                        )
                ),
                product(
                        10,
                        "iam-waist-bag",
                        "IAM Waist Bag",
                        198000,
                        "https://images.unsplash.com/photo-1542291026-7eec264c27ff?auto=format&fit=crop&w=900&q=80",
                        "Accessories",
                        "Core Gear",
                        4.4,
                        8,
                        "Compact utility waist bag with weather-resistant shell fabric, modular pockets, and an adjustable cross-body strap.",
                        false,
                        List.of("Water-resistant outer shell", "Two compartment storage", "Adjustable quick-release strap", "Hidden inner pocket"),
                        List.of("One Size"),
                        List.of(
                                "https://images.unsplash.com/photo-1542291026-7eec264c27ff?auto=format&fit=crop&w=900&q=80",
                                "https://images.unsplash.com/photo-1553062407-98eeb64c6a62?auto=format&fit=crop&w=900&q=80",
                                "https://images.unsplash.com/photo-1512436991641-6745cdb1723f?auto=format&fit=crop&w=900&q=80"
                        )
                )
        ));

        collectionHeroRepository.save(new CollectionHero(
                "Bloodthorn",
                "Bloodthorn Collection",
                "Inspired by the thorn of life—bleed, rise, conquer. A focused drop built around sharp line work, dark tones, and premium riding-ready layers.",
                "Explore Collection",
                "https://images.unsplash.com/photo-1517841905240-472988babdf9?auto=format&fit=crop&w=1400&q=80"
        ));

        communityPageRepository.save(new CommunityPage(
                "Community",
                "Built by riders, for riders."
        ));

        communityTabRepository.saveAll(List.of(
                new CommunityTab("Customer Gallery", 1),
                new CommunityTab("Rider Stories", 2),
                new CommunityTab("Events", 3),
                new CommunityTab("Bike Feature", 4)
        ));

        communityPostRepository.saveAll(List.of(
                communityPost(1, "Bandung Night Ride Layering", "https://images.unsplash.com/photo-1517841905240-472988babdf9?auto=format&fit=crop&w=900&q=80", "Customer Gallery"),
                communityPost(2, "IAM Brotherhood at Sunday Morning Ride", "https://images.unsplash.com/photo-1521572163474-6864f9cf17ab?auto=format&fit=crop&w=900&q=80", "Rider Stories"),
                communityPost(3, "Customfest Booth Recap", "https://images.unsplash.com/photo-1500530855697-b586d89ba3ee?auto=format&fit=crop&w=900&q=80", "Events"),
                communityPost(4, "Semut Ireng Builder Story", "https://images.unsplash.com/photo-1493238792000-8113da705763?auto=format&fit=crop&w=900&q=80", "Bike Feature"),
                communityPost(5, "Neuro Drop Spotted in Jogja", "https://images.unsplash.com/photo-1503342217505-b0a15ec3261c?auto=format&fit=crop&w=900&q=80", "Customer Gallery"),
                communityPost(6, "Mooneyes Yokohama Travel Notes", "https://images.unsplash.com/photo-1500534314209-a25ddb2bd429?auto=format&fit=crop&w=900&q=80", "Events")
        ));

        aboutPageRepository.save(new AboutPage(
                "We Are",
                "I'AM Works",
                "Born from the garage and raised on the road, I'AM Works crafts riding apparel that fuses freedom, creativity, and brotherhood into every release.",
                "Stay Wild & Free",
                "Our Story",
                "https://images.unsplash.com/photo-1493238792000-8113da705763?auto=format&fit=crop&w=1400&q=80"
        ));
    }

    private NavigationItem navigationItem(int sortOrder, String label, String href) {
        return new NavigationItem(label, href, sortOrder);
    }

    private HeroFeature heroFeature(int sortOrder, String title, String description) {
        return new HeroFeature(title, description, sortOrder);
    }

    private FooterSocial footerSocial(int sortOrder, String label, String href) {
        return new FooterSocial(label, href, sortOrder);
    }

    private FooterLink footerLink(FooterColumn column, int sortOrder, String label, String href) {
        return new FooterLink(column, label, href, sortOrder);
    }

    private ColorOption colorOption(int sortOrder, String name, String hex) {
        return new ColorOption(name, hex, sortOrder);
    }

    private CommunityPost communityPost(int sortOrder, String title, String image, String tag) {
        return new CommunityPost(title, image, tag, sortOrder);
    }

    private Product product(
            int sortOrder,
            String slug,
            String name,
            long price,
            String image,
            String category,
            String series,
            double rating,
            int reviewCount,
            String description,
            boolean newCollection,
            List<String> highlights,
            List<String> sizes,
            List<String> gallery) {
        Product product = new Product();
        product.setSortOrder(sortOrder);
        product.setSlug(slug);
        product.setName(name);
        product.setPrice(BigDecimal.valueOf(price));
        product.setCurrency("IDR");
        product.setImage(image);
        product.setCategory(category);
        product.setSeries(series);
        product.setRating(BigDecimal.valueOf(rating));
        product.setReviewCount(reviewCount);
        product.setDescription(description);
        product.setNewCollection(newCollection);
        product.setHighlights(highlights);
        product.setSizes(sizes);
        product.setGallery(gallery);
        return product;
    }
}
