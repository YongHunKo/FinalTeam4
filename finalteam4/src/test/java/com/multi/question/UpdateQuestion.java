package com.multi.question;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.QuestionDTO;
import com.multi.service.QuestionService;

@SpringBootTest
class UpdateQuestion {

	@Autowired
	QuestionService service;
	
	@Test
	void contextLoads() {
		QuestionDTO question = new QuestionDTO(6, 3, "id06", "예약문의", "11월 예약은 언제 열리나요?", null);
		try {
			service.modify(question);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}




