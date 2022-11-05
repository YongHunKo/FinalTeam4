package com.multi.cart;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.CartDTO;
import com.multi.service.CartService;

@SpringBootTest
class InsertCart {
	@Autowired
	CartService service;

	@Test
	void contextLoads() {
		try {
			service.register(new CartDTO(null, "id01", 8, 8,null,null,null,null));
			System.out.println("Insert_ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
