package com.multi.selecttime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.SelecttimeDTO;
import com.multi.service.SelecttimeService;

@SpringBootTest
class UpdateSelecttime {
	@Autowired
	SelecttimeService service;

	@Test
	void contextLoads() {
		try {
			service.modify(new SelecttimeDTO(17, "02:00"));
			System.out.println("update_OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
