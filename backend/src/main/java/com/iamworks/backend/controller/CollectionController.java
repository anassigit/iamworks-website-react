package com.iamworks.backend.controller;

import com.iamworks.backend.dto.CollectionsResponse;
import com.iamworks.backend.service.CollectionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/collections")
public class CollectionController {

    private final CollectionService collectionService;

    public CollectionController(CollectionService collectionService) {
        this.collectionService = collectionService;
    }

    @GetMapping
    public CollectionsResponse getCollections() {
        return collectionService.getCollections();
    }
}
