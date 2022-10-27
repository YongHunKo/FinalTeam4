package com.multi.eatadmin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.EatadminDTO;
import com.multi.service.EatadminService;

@SpringBootTest
class GetEatadmin {

	@Autowired
	EatadminService service;
	
	@Test
	void contextLoads() {
		EatadminDTO admin = null;
		try {
			admin = service.get("admin03");
			System.out.println(admin);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}




