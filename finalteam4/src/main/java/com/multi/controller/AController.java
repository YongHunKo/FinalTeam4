package com.multi.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multi.dto.CartDTO;
import com.multi.dto.CustDTO;
import com.multi.dto.OrderlistDTO;
import com.multi.dto.ReserveDTO;
import com.multi.dto.StoreDTO;
import com.multi.service.CartService;
import com.multi.service.CustService;
import com.multi.service.MenuService;
import com.multi.service.OrderlistService;
import com.multi.service.ReserveService;
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
	@Autowired
	OrderlistService orderlistservice;
	@Autowired
	ReserveService reserveservice;
	
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
		List<StoreDTO> list = null;
		try {
			list = storeservice.detail(storeid);
			for(StoreDTO s:list) {
				cartservice.register(new CartDTO(null, custid, s.getMenuid(), cnt,s.getMenuname(),s.getMenuprice(),s.getMenuimg(),(cnt*s.getMenuprice())));			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	@RequestMapping("/edit/reconfirm")
	public Object reconfirm(String custid, String custpwd) {
		String result = "";
		String originpwd = "";
		CustDTO cust = null;

		try {
			cust = cust_service.get(custid);
			originpwd = cust.getCustpwd();

			if (originpwd.equals(custpwd)) {
				result = "true";
			} else {
				result = "false";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
