package com.multi.cart;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.CartDTO;
import com.multi.service.CartService;

@SpringBootTest
class UpdateCart {
	@Autowired
	CartService service;

	@Test
	void contextLoads() {
		try {
			service.modify(new CartDTO(3, "id01", 9, 9,null,3000,null,null,null,null));
			System.out.println("Update_ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
