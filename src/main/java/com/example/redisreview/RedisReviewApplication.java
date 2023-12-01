package com.example.redisreview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class RedisReviewApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisReviewApplication.class, args);
    }

}
