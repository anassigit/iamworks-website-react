package com.iamworks.backend.repository;

import com.iamworks.backend.model.NavigationItem;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NavigationItemRepository extends JpaRepository<NavigationItem, Long> {
    List<NavigationItem> findAllByOrderBySortOrderAsc();
}
