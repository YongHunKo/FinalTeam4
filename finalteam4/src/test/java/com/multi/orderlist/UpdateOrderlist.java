package com.multi.orderlist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.OrderlistDTO;
import com.multi.service.OrderlistService;

@SpringBootTest
class UpdateOrderlist {
	@Autowired
	OrderlistService service;

	@Test
	void contextLoads() {
		try {
			service.modify(new OrderlistDTO(6, "id03", null, 66, 666666, null, null, null, null, null, null));
			System.out.println("update_ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
