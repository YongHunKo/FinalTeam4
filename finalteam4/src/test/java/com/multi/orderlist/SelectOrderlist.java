package com.multi.orderlist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.OrderlistDTO;
import com.multi.service.OrderlistService;

@SpringBootTest
class SelectOrderlist {
	@Autowired
	OrderlistService service;

	@Test
	void contextLoads() {
		OrderlistDTO orderlist = null;
		try {
			orderlist = service.get(1);
			System.out.println(orderlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
