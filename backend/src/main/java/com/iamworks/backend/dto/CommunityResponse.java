package com.iamworks.backend.dto;

import java.util.List;

public record CommunityResponse(String title, String subtitle, List<String> tabs, List<Post> posts) {

    public record Post(String title, String image, String tag) {
    }
}
