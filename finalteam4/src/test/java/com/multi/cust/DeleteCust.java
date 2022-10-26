package com.multi.cust;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.service.CustService;

@SpringBootTest
class DeleteCust {
	@Autowired
	CustService service;

	@Test
	void contextLoads() {
		try {
			service.remove("id11");
			System.out.println("remove_ok");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
