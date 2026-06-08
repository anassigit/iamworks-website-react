package com.iamworks.backend.controller;

import com.iamworks.backend.dto.CommunityResponse;
import com.iamworks.backend.service.CommunityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/community")
public class CommunityController {

    private final CommunityService communityService;

    public CommunityController(CommunityService communityService) {
        this.communityService = communityService;
    }

    @GetMapping
    public CommunityResponse getCommunity() {
        return communityService.getCommunity();
    }
}
