package com.multi.wishlist;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.WishlistDTO;
import com.multi.service.WishlistService;

@SpringBootTest
class ViewwishWishlist {
	@Autowired
	WishlistService service;
	
	@Test
	void contextLoads() {
		List<WishlistDTO> list = null;
		try {
			list = service.viewwish("id01");
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(WishlistDTO s:list) {
			System.out.println(s);
		}
	}
}
