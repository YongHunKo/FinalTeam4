package com.multi.orderlist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.service.OrderlistService;

@SpringBootTest
class DeleteOrderlist {
	@Autowired
	OrderlistService service;

	@Test
	void contextLoads() {
		try {
			service.remove(6);
			System.out.println("delete_ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
