package com.multi.eatadm;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.service.EatAdmService;

@SpringBootTest
public class DeleteAdm {
	
	@Autowired
	EatAdmService service;
	
	@Test
	void contextLoads() {
		try {
			service.remove("admin04");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
