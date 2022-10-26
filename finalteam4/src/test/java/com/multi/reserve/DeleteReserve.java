package com.multi.reserve;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.service.ReserveService;

@SpringBootTest
class DeleteReserve {

	@Autowired
	ReserveService service;
	
	@Test
	void contextLoads() {
		try {
			service.remove(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}




