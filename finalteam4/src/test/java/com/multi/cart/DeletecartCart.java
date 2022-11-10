package com.multi.cart;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.CartDTO;
import com.multi.service.CartService;

@SpringBootTest
class DeletecartCart {
	@Autowired
	CartService service;

	@Test
	void contextLoads() {
		try {
			if(service.selectcart("id01") !=null) {
				service.deletecart("id01");
			}			
				System.out.println("delete_ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
