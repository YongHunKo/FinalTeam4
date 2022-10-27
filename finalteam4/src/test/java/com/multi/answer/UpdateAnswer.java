package com.multi.answer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.AnswerDTO;
import com.multi.service.AnswerService;

@SpringBootTest
class UpdateAnswer {

	@Autowired
	AnswerService service;
	
	@Test
	void contextLoads() {
		AnswerDTO answer = new AnswerDTO(5, "admin01", 5, "예약문의관련답변입니다", "쿨키지 비용은 병당 5만입니다", null);
		try {
			service.modify(answer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}




