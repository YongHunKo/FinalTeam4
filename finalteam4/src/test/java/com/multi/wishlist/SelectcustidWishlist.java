package com.multi.wishlist;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.WishlistDTO;
import com.multi.service.WishlistService;

@SpringBootTest
class SelectcustidWishlist {
	@Autowired
	WishlistService service;

	@Test
	void contextLoads() {
		List<WishlistDTO> list = null;
		try {
			list = service.selectcustid("id05");
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(WishlistDTO w:list) {
			System.out.println(w);
		}
	}

}
