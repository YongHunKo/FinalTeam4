package com.multi.question;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.QuestionDTO;
import com.multi.service.QuestionService;


@SpringBootTest
class InsertQuestion {

	@Autowired
	QuestionService service;
	
	@Test
	void contextLoads() {
		try {
			service.register(new QuestionDTO(null, 3, "id06", "주차문의", "주차장이 있나요?", null));
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}




