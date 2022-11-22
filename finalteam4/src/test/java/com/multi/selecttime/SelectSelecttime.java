package com.multi.selecttime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.SelecttimeDTO;
import com.multi.service.SelecttimeService;

@SpringBootTest
class SelectSelecttime {
	@Autowired
	SelecttimeService service;

	@Test
	void contextLoads() {
		SelecttimeDTO selecttime = null;
		try {
			selecttime= service.get(17);
			System.out.println(selecttime);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
