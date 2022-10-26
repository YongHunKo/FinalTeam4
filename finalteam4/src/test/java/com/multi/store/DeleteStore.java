package com.multi.store;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.service.StoreService;

@SpringBootTest
class DeleteStore {
	@Autowired
	StoreService service;

	@Test
	void contextLoads() {
		try {
			service.remove(3);
			System.out.println("delete_ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
