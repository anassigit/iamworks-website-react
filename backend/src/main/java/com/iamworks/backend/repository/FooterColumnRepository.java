package com.iamworks.backend.repository;

import com.iamworks.backend.model.FooterColumn;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FooterColumnRepository extends JpaRepository<FooterColumn, Long> {
    List<FooterColumn> findAllByOrderBySortOrderAsc();
}
