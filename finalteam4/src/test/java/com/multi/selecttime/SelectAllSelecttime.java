package com.multi.selecttime;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.SelecttimeDTO;
import com.multi.service.SelecttimeService;

@SpringBootTest
class SelectAllSelecttime {
	@Autowired
	SelecttimeService service;

	@Test
	void contextLoads() {
		List<SelecttimeDTO> list = null;
		try {
			list = service.getall();
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(SelecttimeDTO s:list) {
			System.out.println(s);
		}
	}

}
