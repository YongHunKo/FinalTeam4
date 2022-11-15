package com.multi.wishlist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.service.WishlistService;

@SpringBootTest
class DeleteWishlist {

	@Autowired
	WishlistService service;
	
	@Test
	void contextLoads() {
		try {
			service.remove(19);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}




