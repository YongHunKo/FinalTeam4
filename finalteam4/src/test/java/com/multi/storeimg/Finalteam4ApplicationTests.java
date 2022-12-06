package com.multi.storeimg;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.StoreimgDTO;
import com.multi.service.StoreimgService;

@SpringBootTest
class Finalteam4ApplicationTests {
	@Autowired
	StoreimgService service;

	@Test
	void contextLoads() {
		StoreimgDTO storeimg = null;
		try {
			storeimg = service.shareimg(2);
			System.out.println(storeimg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
