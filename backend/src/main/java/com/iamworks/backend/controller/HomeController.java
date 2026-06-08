package com.iamworks.backend.controller;

import com.iamworks.backend.dto.HomeResponse;
import com.iamworks.backend.service.HomeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/home")
public class HomeController {

    private final HomeService homeService;

    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping
    public HomeResponse getHome() {
        return homeService.getHome();
    }
}
