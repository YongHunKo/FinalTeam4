package com.multi.reserve;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.PayDTO;
import com.multi.dto.ReserveDTO;
import com.multi.service.ReserveService;

@SpringBootTest
class GetAllReserve {

	@Autowired
	ReserveService service;
	
	@Test
	void contextLoads() {
		List<ReserveDTO> list = null;
		try {
			list = service.getall();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(ReserveDTO c:list) {
			System.out.println(c);
		}
		
	}

}




