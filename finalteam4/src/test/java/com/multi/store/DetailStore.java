package com.multi.store;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.StoreDTO;
import com.multi.service.StoreService;

@SpringBootTest
class DetailStore {
	@Autowired
	StoreService service;

	@Test
	void contextLoads() {
		List<StoreDTO> list = null;
		try {
			list = service.detail(5);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(StoreDTO s:list) {
			System.out.println(s);
		}
	}

}
