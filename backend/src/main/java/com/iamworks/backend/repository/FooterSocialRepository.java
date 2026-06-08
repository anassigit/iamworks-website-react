package com.iamworks.backend.repository;

import com.iamworks.backend.model.FooterSocial;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FooterSocialRepository extends JpaRepository<FooterSocial, Long> {
    List<FooterSocial> findAllByOrderBySortOrderAsc();
}
