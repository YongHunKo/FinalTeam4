package com.multi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multi.dto.CustDTO;
import com.multi.service.CustService;

@RestController
public class AController {

	@Autowired
	CustService cust_service;
	
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
}
