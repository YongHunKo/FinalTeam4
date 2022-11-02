package com.multi.store;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.StoreDTO;
import com.multi.service.StoreService;

@SpringBootTest
class UpdateStore {
	@Autowired
	StoreService service;

	@Test
	void contextLoads() {
		try {
			service.modify(new StoreDTO(99, 200, "test33", "test33입니다", "064-333-3333", "영업시간 종료", "영업시간안내","addr test33",null,null,null,null,null,null,null));
			System.out.println("updat_ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
