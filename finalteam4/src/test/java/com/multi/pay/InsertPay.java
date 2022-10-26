package com.multi.pay;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.PayDTO;
import com.multi.service.PayService;

@SpringBootTest
class InsertPay {

	@Autowired
	PayService service;
	
	@Test
	void contextLoads() {
		try {
			service.register(new PayDTO(null, 6, "id06", 60000, "결제완료"));
			System.out.println("OK");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}




