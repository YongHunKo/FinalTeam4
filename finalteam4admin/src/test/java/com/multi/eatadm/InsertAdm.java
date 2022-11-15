package com.multi.eatadm;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.EatAdmDTO;
import com.multi.service.EatAdmService;

@SpringBootTest
class InsertAdm {

	@Autowired
	EatAdmService service;
	
	@Test
	void contextLoads() {
		EatAdmDTO adm = new EatAdmDTO("admin04", "pwd04", "김성진", 3);
		try {
			service.register(adm);
			System.out.println("OK");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}



