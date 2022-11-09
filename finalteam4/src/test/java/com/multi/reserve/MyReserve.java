package com.multi.reserve;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.PayDTO;
import com.multi.dto.ReserveDTO;
import com.multi.service.ReserveService;

@SpringBootTest
class MyReserve {

	@Autowired
	ReserveService service;

	@Test
	void contextLoads() {
		List<ReserveDTO> list = null;
		try {
			list = service.myreserve(1);
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (ReserveDTO r : list) {
			System.out.println(r);
		}

	}

}
