package com.multi.wishlist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.WishlistDTO;
import com.multi.service.WishlistService;

@SpringBootTest
class UpdateWishlist {

	@Autowired
	WishlistService service;
	
	@Test
	void contextLoads() {
		WishlistDTO cart = new WishlistDTO(6,5,"id06", null);
		try {
			service.modify(cart);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}




