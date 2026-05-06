package com.lokesh.urlshortener.controller;

import com.lokesh.urlshortener.entity.UrlMapping;
import com.lokesh.urlshortener.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class UrlController {

    @Autowired
    private UrlService urlService;

    @GetMapping("/shorten")
    public String shortenUrl(
            @RequestParam String originalUrl,
            @RequestParam(required = false) String customAlias) {

        UrlMapping urlMapping =
                urlService.saveUrl(originalUrl, customAlias);

        return "Short URL: http://localhost:8080/"
                + urlMapping.getShortCode();
    }

    @GetMapping("/{shortCode}")
    public RedirectView redirectUrl(@PathVariable String shortCode) {

        UrlMapping urlMapping = urlService.getOriginalUrl(shortCode);

        if (urlMapping == null) {
            return new RedirectView("http://localhost:8080/error");
        }

        return new RedirectView(urlMapping.getOriginalUrl());
    }
}