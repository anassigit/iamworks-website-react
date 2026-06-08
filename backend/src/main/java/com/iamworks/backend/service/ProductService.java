package com.iamworks.backend.service;

import com.iamworks.backend.dto.ProductCardResponse;
import com.iamworks.backend.dto.ProductDetailResponse;
import com.iamworks.backend.dto.ProductsResponse;
import com.iamworks.backend.model.Product;
import com.iamworks.backend.model.ProductCatalogPage;
import com.iamworks.backend.repository.ColorOptionRepository;
import com.iamworks.backend.repository.ProductCatalogPageRepository;
import com.iamworks.backend.repository.ProductRepository;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ProductService {

    private static final Map<String, Integer> CATEGORY_ORDER = Map.of(
            "Hoodie", 1,
            "Crewneck", 2,
            "T-Shirt", 3,
            "Gloves", 4,
            "Accessories", 5,
            "Limited Edition", 6);

    private static final Map<String, Integer> SIZE_ORDER = new LinkedHashMap<>();
    private static final Map<String, Integer> SERIES_ORDER = new LinkedHashMap<>();

    static {
        SIZE_ORDER.put("XS", 1);
        SIZE_ORDER.put("S", 2);
        SIZE_ORDER.put("M", 3);
        SIZE_ORDER.put("L", 4);
        SIZE_ORDER.put("XL", 5);
        SIZE_ORDER.put("XXL", 6);
        SIZE_ORDER.put("One Size", 7);

        SERIES_ORDER.put("Bloodthorn", 1);
        SERIES_ORDER.put("Neuro", 2);
        SERIES_ORDER.put("Clown Psycho", 3);
        SERIES_ORDER.put("Dominus Noctis", 4);
        SERIES_ORDER.put("Black Voltage", 5);
        SERIES_ORDER.put("Chrome Phantom", 6);
        SERIES_ORDER.put("Core Gear", 7);
    }

    private final ProductCatalogPageRepository productCatalogPageRepository;
    private final ColorOptionRepository colorOptionRepository;
    private final ProductRepository productRepository;

    public ProductService(
            ProductCatalogPageRepository productCatalogPageRepository,
            ColorOptionRepository colorOptionRepository,
            ProductRepository productRepository) {
        this.productCatalogPageRepository = productCatalogPageRepository;
        this.colorOptionRepository = colorOptionRepository;
        this.productRepository = productRepository;
    }

    public ProductsResponse getProducts() {
        ProductCatalogPage page = productCatalogPageRepository.findTopByOrderByIdAsc()
                .orElseThrow(() -> new IllegalStateException("Product catalog page not found"));
        List<Product> products = productRepository.findAllByOrderBySortOrderAsc();

        List<String> categories = products.stream()
                .map(Product::getCategory)
                .distinct()
                .sorted(Comparator.comparingInt(category -> CATEGORY_ORDER.getOrDefault(category, 999)))
                .toList();

        List<String> sizes = products.stream()
                .flatMap(product -> product.getSizes().stream())
                .distinct()
                .sorted(Comparator.comparingInt(size -> SIZE_ORDER.getOrDefault(size, 999)))
                .toList();

        List<String> series = products.stream()
                .map(Product::getSeries)
                .distinct()
                .sorted(Comparator.comparingInt(item -> SERIES_ORDER.getOrDefault(item, 999)))
                .toList();

        return new ProductsResponse(
                page.getTitle(),
                page.getSummary(),
                categories,
                new ProductsResponse.Filters(
                        sizes,
                        colorOptionRepository.findAllByOrderBySortOrderAsc().stream()
                                .map(color -> new ProductsResponse.ColorOption(color.getName(), color.getHex()))
                                .toList(),
                        series),
                products.stream().map(this::toProductCard).toList());
    }

    public ProductDetailResponse getProduct(String slug) {
        Product product = productRepository.findBySlug(slug)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));

        List<ProductCardResponse> related = productRepository.findBySeriesAndSlugNotOrderBySortOrderAsc(product.getSeries(), product.getSlug()).stream()
                .map(this::toProductCard)
                .limit(4)
                .toList();

        if (related.isEmpty()) {
            related = productRepository.findByCategoryAndSlugNotOrderBySortOrderAsc(product.getCategory(), product.getSlug()).stream()
                    .map(this::toProductCard)
                    .limit(4)
                    .toList();
        }

        return new ProductDetailResponse(
                product.getSlug(),
                product.getName(),
                product.getPrice(),
                product.getCurrency(),
                product.getRating(),
                product.getReviewCount(),
                product.getDescription(),
                product.getHighlights(),
                product.getSizes(),
                product.getGallery(),
                product.getSeries(),
                product.getCategory(),
                related);
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
