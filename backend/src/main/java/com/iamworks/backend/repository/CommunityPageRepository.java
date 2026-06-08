package com.iamworks.backend.repository;

import com.iamworks.backend.model.CommunityPage;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityPageRepository extends JpaRepository<CommunityPage, Long> {
    Optional<CommunityPage> findTopByOrderByIdAsc();
}
