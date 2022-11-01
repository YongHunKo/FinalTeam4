package com.multi.store;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.StoreDTO;
import com.multi.service.StoreService;

@SpringBootTest
class InsertStore {
	@Autowired
	StoreService service;

	@Test
	void contextLoads() {
		try {
			service.register(new StoreDTO(99, 100, "test03", "test03입니다", "064-777-7777", "예약가능", "영업시간","addr test3",null,null,null,null,null,null));
			System.out.println("insert_ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
