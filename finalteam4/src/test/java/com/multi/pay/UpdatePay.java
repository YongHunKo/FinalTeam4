package com.multi.pay;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.PayDTO;
import com.multi.service.PayService;

@SpringBootTest
class UpdatePay {

	@Autowired
	PayService service;
	
	@Test
	void contextLoads() {
		PayDTO pay = new PayDTO(1,5,70000,"결제대기");
		try {
			service.modify(pay);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}




