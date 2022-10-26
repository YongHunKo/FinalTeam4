package com.multi.reserve;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.ReserveDTO;
import com.multi.service.ReserveService;

@SpringBootTest
class GetReserve {

	@Autowired
	ReserveService service;
	
	@Test
	void contextLoads() {
		ReserveDTO reserve = null;
		try {
			reserve = service.get(1);
			System.out.println(reserve);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}




