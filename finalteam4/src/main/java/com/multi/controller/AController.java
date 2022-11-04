package com.multi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multi.dto.CartDTO;
import com.multi.dto.CustDTO;
import com.multi.dto.MenuDTO;
import com.multi.service.CartService;
import com.multi.service.CustService;
import com.multi.service.MenuService;
import com.multi.service.StoreService;

@RestController
public class AController {

	@Autowired
	CustService cust_service;
	@Autowired
	CartService cartservice;
	@Autowired
	StoreService storeservice;
	@Autowired
	MenuService menuservice;
	
	@RequestMapping("/checkid")
	public Object checkid(String cid) {
		String result = "";
		CustDTO cust = null;
		try {
			cust = cust_service.get(cid);
			if(cust != null) {
				result = "f";
			}else {
				result = "t";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//미완
	@RequestMapping("/addcart")
	public String addcart(Model model, String custid, Integer cnt, Integer storeid) {
		List<MenuDTO> list = null;
		try {
			cartservice.register(new CartDTO(null, custid, null, cnt));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}
