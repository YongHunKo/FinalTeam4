package com.multi.cart;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.service.CartService;

@SpringBootTest
class DeleteCart {
	@Autowired
	CartService service;

	@Test
	void contextLoads() {
		try {
			service.remove(3);
			System.out.println("Delete_Ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
