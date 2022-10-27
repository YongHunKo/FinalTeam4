package com.multi.eatadmin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.EatadminDTO;
import com.multi.service.EatadminService;

@SpringBootTest
class UpdateEatadmin {

	@Autowired
	EatadminService service;
	
	@Test
	void contextLoads() {
		EatadminDTO admin = new EatadminDTO("admin04", "pwd00", "Henry", 3);
		try {
			service.modify(admin);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}




