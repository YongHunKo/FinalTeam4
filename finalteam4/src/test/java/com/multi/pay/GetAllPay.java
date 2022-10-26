package com.multi.pay;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.multi.dto.PayDTO;
import com.multi.service.PayService;

@SpringBootTest
class GetAllPay {

	@Autowired
	PayService service;
	
	@Test
	void contextLoads() {
		List<PayDTO> list = null;
		try {
			list = service.getall();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(PayDTO c:list) {
			System.out.println(c);
		}
		
	}

}




