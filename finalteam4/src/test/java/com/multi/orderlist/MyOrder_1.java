package com.multi.orderlist;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.OrderlistDTO;
import com.multi.service.OrderlistService;

@SpringBootTest
class MyOrder_1 {

	@Autowired
	OrderlistService service;

	@Test
	void contextLoads() {
		OrderlistDTO orderlist = null;
		try {
			orderlist = service.myorder_1("id01");
			System.out.println(orderlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
