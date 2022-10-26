package com.multi.menu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.MenuDTO;
import com.multi.service.MenuService;

@SpringBootTest
public class GetMenu {

	@Autowired
	MenuService menu_service;
	
	@Test
	void contextLoads() {
		MenuDTO menu = null;
		
		try {
			menu = menu_service.get(1);
			System.out.println(menu);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
