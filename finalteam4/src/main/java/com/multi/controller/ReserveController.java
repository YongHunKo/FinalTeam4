package com.multi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.StoreDTO;
import com.multi.service.StoreService;

@Controller
public class ReserveController {
	@Autowired
	StoreService storeservice;
	
	@RequestMapping("/reserveimpl")
	public String reserveimpl(Model model, Integer storeid) {
		List<StoreDTO>list = null;
		try {
			list = storeservice.detail(storeid);
			model.addAttribute("menulist",list);
			model.addAttribute("center","/reserve");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "index";
	}

}
