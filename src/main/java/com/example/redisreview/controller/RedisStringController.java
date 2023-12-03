package com.example.redisreview.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/redis-string")
@RestController
public class RedisStringController {

    private final StringRedisTemplate redisTemplate;

    @GetMapping("/set-fruit")
    public String setFruit(@RequestParam String fruitName) {
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        ops.set("fruit", fruitName);

        return "saved";
    }

    @GetMapping("/get-fruit")
    public String getFruit() {
        ValueOperations<String, String> ops = redisTemplate.opsForValue();

        return ops.get("fruit");
    }
}
