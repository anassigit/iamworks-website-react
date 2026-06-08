package com.iamworks.backend.repository;

import com.iamworks.backend.model.CommunityTab;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityTabRepository extends JpaRepository<CommunityTab, Long> {
    List<CommunityTab> findAllByOrderBySortOrderAsc();
}
