package com.multi.store;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.StoreDTO;
import com.multi.service.StoreService;

@SpringBootTest
class SelectStore {
	@Autowired
	StoreService service;

	@Test
	void contextLoads() {
		StoreDTO store = null;
		try {
			store = service.get(3);
			System.out.println(store);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
