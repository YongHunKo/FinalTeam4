package com.multi.answer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.service.AnswerService;

@SpringBootTest
class DeleteAnswer {

	@Autowired
	AnswerService service;
	
	@Test
	void contextLoads() {
		try {
			service.remove(5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}




