package com.multi.eatadmin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.EatadminDTO;
import com.multi.service.EatadminService;

@SpringBootTest
class InsertEatadmin {

	@Autowired
	EatadminService service;
	
	@Test
	void contextLoads() {
		try {
			service.register(new EatadminDTO("admin04", "pwd04", "Adam", 3));
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}




