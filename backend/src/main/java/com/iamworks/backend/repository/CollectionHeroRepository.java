package com.iamworks.backend.repository;

import com.iamworks.backend.model.CollectionHero;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollectionHeroRepository extends JpaRepository<CollectionHero, Long> {
    Optional<CollectionHero> findTopByOrderByIdAsc();
}
