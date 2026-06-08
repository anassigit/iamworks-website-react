package com.iamworks.backend.repository;

import com.iamworks.backend.model.HeroFeature;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroFeatureRepository extends JpaRepository<HeroFeature, Long> {
    List<HeroFeature> findAllByOrderBySortOrderAsc();
}
