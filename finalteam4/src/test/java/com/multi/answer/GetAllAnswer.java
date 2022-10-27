package com.multi.answer;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.AnswerDTO;
import com.multi.service.AnswerService;

@SpringBootTest
class GetAllAnswer {

	@Autowired
	AnswerService service;
	
	@Test
	void contextLoads() {
		List<AnswerDTO> list = null;
		try {
			list = service.getall();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(AnswerDTO c:list) {
			System.out.println(c);
		}
		
	}

}




