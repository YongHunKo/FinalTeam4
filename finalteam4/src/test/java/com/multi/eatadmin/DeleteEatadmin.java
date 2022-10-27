package com.multi.eatadmin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.service.EatadminService;

@SpringBootTest
class DeleteEatadmin {

	@Autowired
	EatadminService service;
	
	@Test
	void contextLoads() {
		try {
			service.remove("admin04");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}




