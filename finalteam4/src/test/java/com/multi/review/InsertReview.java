package com.multi.review;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.ReviewDTO;
import com.multi.service.ReviewService;

@SpringBootTest
public class InsertReview {

	@Autowired
	ReviewService review_service;

	@Test
	void contextLoads() {
		try {
			review_service.register(new ReviewDTO(null, "id06", 3, "군침이 싸악 돕니다.", 5, null));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Insert Ok");
	}
}