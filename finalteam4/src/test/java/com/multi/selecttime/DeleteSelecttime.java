package com.multi.selecttime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.SelecttimeDTO;
import com.multi.service.SelecttimeService;

@SpringBootTest
class DeleteSelecttime {
	@Autowired
	SelecttimeService service;

	@Test
	void contextLoads() {
		try {
			service.remove(17);
			System.out.println("delete_OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
