package com.multi.answer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.AnswerDTO;
import com.multi.service.AnswerService;

@SpringBootTest
class InsertAnswer {

	@Autowired
	AnswerService service;
	
	@Test
	void contextLoads() {
		try {
			service.register(new AnswerDTO(null, "admin01", 5, "예약문의관련답변입니다", "쿨키지비용은병당3만입니다", null));
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}




