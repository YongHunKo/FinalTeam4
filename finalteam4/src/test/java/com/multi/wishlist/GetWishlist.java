package com.multi.wishlist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.WishlistDTO;
import com.multi.service.WishlistService;

@SpringBootTest
class GetWishlist {

	@Autowired
	WishlistService service;
	
	@Test
	void contextLoads() {
		WishlistDTO carts = null;
		try {
			carts = service.get(1);
			System.out.println(carts);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}




