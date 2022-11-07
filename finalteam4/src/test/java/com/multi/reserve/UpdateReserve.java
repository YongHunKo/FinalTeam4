package com.multi.reserve;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.ReserveDTO;
import com.multi.service.ReserveService;

@SpringBootTest
class UpdateReserve {

	@Autowired
	ReserveService service;
	
	@Test
	void contextLoads() {
		ReserveDTO reserve = new ReserveDTO(5, 0, null, 7, 10);
		try {
			service.modify(reserve);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}




