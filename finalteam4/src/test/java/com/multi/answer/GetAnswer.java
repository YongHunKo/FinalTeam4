package com.multi.answer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.AnswerDTO;
import com.multi.service.AnswerService;

@SpringBootTest
class GetAnswer {

	@Autowired
	AnswerService service;
	
	@Test
	void contextLoads() {
		AnswerDTO Answer = null;
		try {
			Answer = service.get(4);
			System.out.println(Answer);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}




