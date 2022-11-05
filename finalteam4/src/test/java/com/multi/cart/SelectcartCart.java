package com.multi.cart;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.CartDTO;
import com.multi.service.CartService;

@SpringBootTest
class SelectcartCart {
	@Autowired
	CartService service;

	@Test
	void contextLoads() {
		List<CartDTO> list = null;
		try {
			list = service.selectcart("id01");
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(CartDTO c:list) {
			System.out.println(c);
		}
	}

}
