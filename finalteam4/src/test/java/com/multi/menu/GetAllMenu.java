package com.multi.menu;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.MenuDTO;
import com.multi.service.MenuService;

@SpringBootTest
public class GetAllMenu {
	
	@Autowired
	MenuService menu_service;
	
	@Test
	void contextLoads() {
		List<MenuDTO> list = null;
		
		try {
			list = menu_service.getall();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(MenuDTO m : list) {
			System.out.println(m);
		}
	}
}
