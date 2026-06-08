package com.iamworks.backend.repository;

import com.iamworks.backend.model.CommunityPost;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityPostRepository extends JpaRepository<CommunityPost, Long> {
    List<CommunityPost> findAllByOrderBySortOrderAsc();
}
