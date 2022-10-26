package com.multi.cust;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.CustDTO;
import com.multi.service.CustService;

@SpringBootTest
class UpdateCust {
	@Autowired
	CustService service;

	@Test
	void contextLoads() {
		try {
			service.modify(new CustDTO("id11", "pwd22", "test22", null, null, null));
			System.out.println("update_ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
