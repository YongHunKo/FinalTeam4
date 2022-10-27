package com.multi.eatadmin;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.EatadminDTO;
import com.multi.service.EatadminService;

@SpringBootTest
class GetAllEatadmin {

	@Autowired
	EatadminService service;
	
	@Test
	void contextLoads() {
		List<EatadminDTO> list = null;
		try {
			list = service.getall();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(EatadminDTO c:list) {
			System.out.println(c);
		}
		
	}

}




