package com.lokesh.urlshortener.service;

import com.lokesh.urlshortener.entity.UrlMapping;
import com.lokesh.urlshortener.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UrlService {

    @Autowired
    private UrlRepository urlRepository;

    private static final String CHARACTERS =
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    private static final int SHORT_URL_LENGTH = 6;

    public String generateShortCode() {

        Random random = new Random();

        StringBuilder shortCode = new StringBuilder();

        for (int i = 0; i < SHORT_URL_LENGTH; i++) {

            int index = random.nextInt(CHARACTERS.length());

            shortCode.append(CHARACTERS.charAt(index));
        }

        return shortCode.toString();
    }

    public UrlMapping saveUrl(String originalUrl, String customAlias) {

        String shortCode;

        if (customAlias != null && !customAlias.isEmpty()) {

            if (urlRepository.existsByShortCode(customAlias)) {
                throw new RuntimeException("Custom alias already exists!");
            }

            shortCode = customAlias;

        } else {
            shortCode = generateShortCode();
        }

        UrlMapping urlMapping =
                new UrlMapping(originalUrl, shortCode);

        return urlRepository.save(urlMapping);
    }

    public UrlMapping getOriginalUrl(String shortCode) {

        UrlMapping urlMapping =
                urlRepository.findByShortCode(shortCode).orElse(null);

        if (urlMapping != null) {

            urlMapping.setClickCount(
                    urlMapping.getClickCount() + 1
            );

            urlRepository.save(urlMapping);
        }

        return urlMapping;
    }
}