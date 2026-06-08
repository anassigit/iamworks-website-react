package com.iamworks.backend.controller;

import com.iamworks.backend.dto.AboutResponse;
import com.iamworks.backend.service.AboutService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/about")
public class AboutController {

    private final AboutService aboutService;

    public AboutController(AboutService aboutService) {
        this.aboutService = aboutService;
    }

    @GetMapping
    public AboutResponse getAbout() {
        return aboutService.getAbout();
    }
}
