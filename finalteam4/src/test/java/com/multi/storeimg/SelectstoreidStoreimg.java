package com.multi.storeimg;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.StoreimgDTO;
import com.multi.service.StoreimgService;

@SpringBootTest
class SelectstoreidStoreimg {
	@Autowired
	StoreimgService service;

	@Test
	void contextLoads() {
		List<StoreimgDTO> list = null;
		try {
			list = service.selectstoreid(5);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(StoreimgDTO s:list) {
			System.out.println(s);
		}
	}

}
