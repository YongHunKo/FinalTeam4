package com.multi.pay;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.service.PayService;

@SpringBootTest
class DeletePay {

	@Autowired
	PayService service;
	
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




