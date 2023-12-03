package com.example.redisreview.controller;

import com.example.redisreview.dto.UserProfile;
import com.example.redisreview.dto.UserScore;
import com.example.redisreview.service.RankingService;
import com.example.redisreview.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ZSetOperations.TypedTuple;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping(value = "/api")
@RestController
public class ApiController {

    private final UserService userService;
    private final RankingService rankingService;

    @GetMapping("/users/{userId}/profile")
    public UserProfile getUserProfile(@PathVariable String userId) {
        return userService.getUserProfile(userId);
    }

    @PostMapping("/users/{userId}/set-score")
    public Boolean setUserScore(@PathVariable String userId,
                                @RequestBody UserScore userScore) {
        return rankingService.setUserScore(userId, userScore.score());
    }

    @GetMapping("/users/{userId}/rank")
    public Long getUserRank(@PathVariable String userId) {
        return rankingService.getUserRank(userId);
    }

    @GetMapping("/users/ranking")
    public List<TypedTuple<String>> getTopUserRanking(@RequestParam Long limit) {
        return rankingService.getTopUserRanking(limit);
    }
}
