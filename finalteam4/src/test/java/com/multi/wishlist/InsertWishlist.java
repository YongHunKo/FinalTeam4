package com.multi.wishlist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.WishlistDTO;
import com.multi.service.WishlistService;

@SpringBootTest
class InsertWishlist {

	@Autowired
	WishlistService service;
	
	@Test
	void contextLoads() {
		try {
			service.register(new WishlistDTO(0, 5, "id05", null));
			System.out.println("OK");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}




