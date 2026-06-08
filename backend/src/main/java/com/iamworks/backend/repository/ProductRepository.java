package com.iamworks.backend.repository;

import com.iamworks.backend.model.Product;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByOrderBySortOrderAsc();
    List<Product> findByNewCollectionTrueOrderBySortOrderAsc();
    Optional<Product> findBySlug(String slug);
    List<Product> findBySeriesAndSlugNotOrderBySortOrderAsc(String series, String slug);
    List<Product> findByCategoryAndSlugNotOrderBySortOrderAsc(String category, String slug);
    List<Product> findBySeriesOrderBySortOrderAsc(String series);
}
