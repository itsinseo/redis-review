package com.example.redisreview;

import com.example.redisreview.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedisReviewApplication implements CommandLineRunner {

	@Autowired
	private ChatService chatService;

	public static void main(String[] args) {
		SpringApplication.run(RedisReviewApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String chatRoomName = "room1";

		System.out.println("Redis Chat Application started");

		chatService.enterChatRoom(chatRoomName);
	}
}
