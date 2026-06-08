package com.iamworks.backend.repository;

import com.iamworks.backend.model.AboutPage;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AboutPageRepository extends JpaRepository<AboutPage, Long> {
    Optional<AboutPage> findTopByOrderByIdAsc();
}
