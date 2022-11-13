package com.multi.eatadm;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.EatAdmDTO;
import com.multi.service.EatAdmService;

@SpringBootTest
class GetAllAdm {

	@Autowired
	EatAdmService service;
	
	@Test
	void contextLoads() {
		List<EatAdmDTO> list = null;
		try {
			list = service.getall();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(EatAdmDTO c:list) {
			System.out.println(c);
		}
		
	}

}




