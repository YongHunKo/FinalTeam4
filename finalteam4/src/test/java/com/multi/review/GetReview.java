package com.multi.review;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.ReviewDTO;
import com.multi.service.ReviewService;

@SpringBootTest
public class GetReview {

	@Autowired
	ReviewService review_service;
	
	@Test
	void contextLoads() {
		ReviewDTO review = null;
		
		try {
			review = review_service.get(1);
			System.out.println(review);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
