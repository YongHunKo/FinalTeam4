package com.multi.cart;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.CartDTO;
import com.multi.service.CartService;

@SpringBootTest
class UpdatecntCart {
	@Autowired
	CartService service;

	@Test
	void contextLoads() {
		try {
			service.updatecart(new CartDTO(1, "id01", null, 3, null, null, null, null));
			System.out.println("cnt_update");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
