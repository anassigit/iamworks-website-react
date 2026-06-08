package com.iamworks.backend.repository;

import com.iamworks.backend.model.HomePageContent;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomePageContentRepository extends JpaRepository<HomePageContent, Long> {
    Optional<HomePageContent> findTopByOrderByIdAsc();
}
