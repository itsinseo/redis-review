package com.example.redisreview.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.core.ZSetOperations.TypedTuple;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class RankingService {

    private final StringRedisTemplate redisTemplate;
    private ZSetOperations<String, String> zSetOps;
    private static final String SCOREBOARD_KEY = "userScoreboard";
    private static final Long BASE_LIMIT = 100L;

    @PostConstruct
    public void init() {
        zSetOps = redisTemplate.opsForZSet();
    }

    public Boolean setUserScore(String userId, Double score) {
        zSetOps.add(SCOREBOARD_KEY, userId, score);

        return true;
    }

    public Long getUserRank(String userId) {
        return zSetOps.reverseRank(SCOREBOARD_KEY, userId);
    }

    public List<TypedTuple<String>> getTopUserRanking(Long limit) {
        if (limit < 1 || limit > BASE_LIMIT) {
            limit = BASE_LIMIT;
        }

        Set<TypedTuple<String>> rangeSet = zSetOps.reverseRangeWithScores(SCOREBOARD_KEY, 0, limit - 1);

        if (rangeSet != null) {
            return new ArrayList<>(rangeSet);
        } else {
            return new ArrayList<>();
        }
    }
}
