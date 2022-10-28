package com.multi.menu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.MenuDTO;
import com.multi.service.MenuService;

@SpringBootTest
public class InsertMenu {

	@Autowired
	MenuService menu_service;

	@Test
	void contextLoads() {
		try {
			menu_service.register(new MenuDTO(3, 3, 3, "상견례상차림", 50000, "백년가약", null));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Insert Ok");
	}
}