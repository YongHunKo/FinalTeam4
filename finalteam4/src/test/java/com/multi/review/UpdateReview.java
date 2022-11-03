package com.multi.review;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.ReviewDTO;
import com.multi.service.ReviewService;

@SpringBootTest
public class UpdateReview {

	@Autowired
	ReviewService review_service;

	@Test
	void contextLoads() {
		try {
			review_service.modify(new ReviewDTO(6, "id07", 2, "별로네요...", 1, null));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Update Ok");
	}
}