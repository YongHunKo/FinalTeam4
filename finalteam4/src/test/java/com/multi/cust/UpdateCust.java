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
			service.modify(new CustDTO("id01", "pwd02", "강민정", null, null, "01087693655",null));
			System.out.println("update_ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
