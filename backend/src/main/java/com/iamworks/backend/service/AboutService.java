package com.iamworks.backend.service;

import com.iamworks.backend.dto.AboutResponse;
import com.iamworks.backend.model.AboutPage;
import com.iamworks.backend.repository.AboutPageRepository;
import org.springframework.stereotype.Service;

@Service
public class AboutService {

    private final AboutPageRepository aboutPageRepository;

    public AboutService(AboutPageRepository aboutPageRepository) {
        this.aboutPageRepository = aboutPageRepository;
    }

    public AboutResponse getAbout() {
        AboutPage page = aboutPageRepository.findTopByOrderByIdAsc()
                .orElseThrow(() -> new IllegalStateException("About page not found"));

        return new AboutResponse(
                page.getTitle(),
                page.getAccentTitle(),
                page.getDescription(),
                page.getScriptText(),
                page.getCtaLabel(),
                page.getHeroImage());
    }
}
