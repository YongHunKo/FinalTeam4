package com.multi.review;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.service.MenuService;
import com.multi.service.ReviewService;

@SpringBootTest
public class DeleteReview {
	
	@Autowired
	ReviewService review_service;
	
	@Test
	void contextLoads() {
		try {
			review_service.remove(6);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Delete Ok");
	}
}
