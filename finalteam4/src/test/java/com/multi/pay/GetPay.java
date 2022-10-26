package com.multi.pay;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.PayDTO;
import com.multi.service.PayService;

@SpringBootTest
class GetPay {

	@Autowired
	PayService service;
	
	@Test
	void contextLoads() {
		PayDTO pay = null;
		try {
			pay = service.get(1);
			System.out.println(pay);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}




