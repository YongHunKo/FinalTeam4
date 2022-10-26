package com.multi.cart;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.CartDTO;
import com.multi.service.CartService;

@SpringBootTest
class GetCart {

	@Autowired
	CartService service;
	
	@Test
	void contextLoads() {
		CartDTO carts = null;
		try {
			carts = service.get(1);
			System.out.println(carts);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}




