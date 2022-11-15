package com.multi.wishlist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.WishlistDTO;
import com.multi.service.WishlistService;

@SpringBootTest
class DeletewishlistWishlist {
	@Autowired
	WishlistService service;

	@Test
	void contextLoads() {
		try {
			service.deletewishlist(new WishlistDTO(null,4,"id05",null,null,null,null));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
