package com.multi.store;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.StoreDTO;
import com.multi.service.StoreService;

@SpringBootTest
class AdminstoreidStore {
	@Autowired
	StoreService service;

	@Test
	void contextLoads() {
		try {
		StoreDTO list = service.adminstoreid(1);
		System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
