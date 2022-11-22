package com.multi.selecttime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.SelecttimeDTO;
import com.multi.service.SelecttimeService;

@SpringBootTest
class InsesrtSelecttime {
	@Autowired
	SelecttimeService service;

	@Test
	void contextLoads() {
		try {
			service.register(new SelecttimeDTO(null, "01:00"));
			System.out.println("insert_OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
