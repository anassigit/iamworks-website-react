package com.iamworks.backend.repository;

import com.iamworks.backend.model.FooterColumn;
import com.iamworks.backend.model.FooterLink;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FooterLinkRepository extends JpaRepository<FooterLink, Long> {
    List<FooterLink> findByColumnRefOrderBySortOrderAsc(FooterColumn columnRef);
}
