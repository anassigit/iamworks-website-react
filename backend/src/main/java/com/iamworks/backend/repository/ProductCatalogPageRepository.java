package com.iamworks.backend.repository;

import com.iamworks.backend.model.ProductCatalogPage;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCatalogPageRepository extends JpaRepository<ProductCatalogPage, Long> {
    Optional<ProductCatalogPage> findTopByOrderByIdAsc();
}
