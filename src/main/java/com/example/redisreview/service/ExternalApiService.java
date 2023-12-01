package com.example.redisreview.service;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ExternalApiService {

    public String getUserName(String userId) {

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }

        System.out.println("getting username from other service...");

        if (userId.equals("A")) {
            return "Adam";
        } else if (userId.equals("B")) {
            return "Bob";
        }

        return "none";
    }

    @Cacheable(cacheNames = "userAgeCache", key = "#userId")
    public int getUserAge(String userId) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }

        System.out.println("getting user age from other service...");

        if (userId.equals("A")) {
            return 20;
        } else if (userId.equals("B")) {
            return 30;
        }

        return -1;
    }
}
