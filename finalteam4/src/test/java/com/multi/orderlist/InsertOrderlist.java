package com.multi.orderlist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.OrderlistDTO;
import com.multi.service.OrderlistService;

@SpringBootTest
class InsertOrderlist {
	@Autowired
	OrderlistService service;

	@Test
	void contextLoads() {
		try {
			service.register(new OrderlistDTO(6, 6, "id01", null, 6, 66666));
			System.out.println("insert_ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
