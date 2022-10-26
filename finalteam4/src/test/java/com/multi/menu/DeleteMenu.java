package com.multi.menu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.service.MenuService;

@SpringBootTest
public class DeleteMenu {
	
	@Autowired
	MenuService menu_service;
	
	@Test
	void contextLoads() {
		try {
			menu_service.remove(3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Delete Ok");
	}
}
