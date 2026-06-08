package com.iamworks.backend.service;

import com.iamworks.backend.dto.CommunityResponse;
import com.iamworks.backend.model.CommunityPage;
import com.iamworks.backend.repository.CommunityPageRepository;
import com.iamworks.backend.repository.CommunityPostRepository;
import com.iamworks.backend.repository.CommunityTabRepository;
import org.springframework.stereotype.Service;

@Service
public class CommunityService {

    private final CommunityPageRepository communityPageRepository;
    private final CommunityTabRepository communityTabRepository;
    private final CommunityPostRepository communityPostRepository;

    public CommunityService(
            CommunityPageRepository communityPageRepository,
            CommunityTabRepository communityTabRepository,
            CommunityPostRepository communityPostRepository) {
        this.communityPageRepository = communityPageRepository;
        this.communityTabRepository = communityTabRepository;
        this.communityPostRepository = communityPostRepository;
    }

    public CommunityResponse getCommunity() {
        CommunityPage page = communityPageRepository.findTopByOrderByIdAsc()
                .orElseThrow(() -> new IllegalStateException("Community page not found"));

        return new CommunityResponse(
                page.getTitle(),
                page.getSubtitle(),
                communityTabRepository.findAllByOrderBySortOrderAsc().stream()
                        .map(tab -> tab.getLabel())
                        .toList(),
                communityPostRepository.findAllByOrderBySortOrderAsc().stream()
                        .map(post -> new CommunityResponse.Post(post.getTitle(), post.getImage(), post.getTag()))
                        .toList());
    }
}
