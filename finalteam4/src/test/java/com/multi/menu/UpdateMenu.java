package com.multi.menu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.MenuDTO;
import com.multi.service.MenuService;

@SpringBootTest
public class UpdateMenu {

	@Autowired
	MenuService menu_service;

	@Test
	void contextLoads() {
		try {
			menu_service.modify(new MenuDTO(2, 1, 2, "한상차림", 20000, "한상차림", null, null));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Update Ok");
	}
}