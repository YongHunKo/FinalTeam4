package com.multi.question;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.service.QuestionService;


@SpringBootTest
class DeleteQuestion {

	@Autowired
	QuestionService service;
	
	@Test
	void contextLoads() {
		try {
			service.remove(6);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}




