package com.multi.question;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.QuestionDTO;
import com.multi.service.QuestionService;



@SpringBootTest
class GetAllQuestion {

	@Autowired
	QuestionService service;
	
	@Test
	void contextLoads() {
		List<QuestionDTO> list = null;
		try {
			list = service.getall();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(QuestionDTO c:list) {
			System.out.println(c);
		}
		
	}

}




