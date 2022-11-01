package com.multi.reserve;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.multi.dto.ReserveDTO;
import com.multi.service.ReserveService;

public class MyResrve {

	@Autowired
	ReserveService service;
	
	@Test
	void contextLoads() {
		List<ReserveDTO> list = null;
		try {
			list = service.myreserve("id01");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(ReserveDTO c : list) {
			System.out.println(c);
		}
		
	}

}
