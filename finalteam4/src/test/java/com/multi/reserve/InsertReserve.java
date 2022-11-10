package com.multi.reserve;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.ReserveDTO;
import com.multi.service.ReserveService;

@SpringBootTest
class InsertReserve {

	@Autowired
	ReserveService service;
	
	@Test
	void contextLoads() {
		try {
			service.register(new ReserveDTO(null, 2, 6, 7, 60000, null, null, null, null, null, null, null, null));
			System.out.println("OK");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}




