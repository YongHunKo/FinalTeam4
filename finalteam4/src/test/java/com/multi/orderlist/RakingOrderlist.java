package com.multi.orderlist;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.OrderlistDTO;
import com.multi.service.OrderlistService;

@SpringBootTest
class RakingOrderlist {
	@Autowired
	OrderlistService service;

	@Test
	void contextLoads() {
		try {
			OrderlistDTO o = service.ranking3();
			System.out.println(o);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
