package com.multi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multi.dto.EatAdmDTO;
import com.multi.service.EatAdmService;

@RestController
public class AController {

	@Autowired
	EatAdmService admservice;
	
	@RequestMapping("/checkid")
	public Object checkid(String cid) {
		String result = "";
		EatAdmDTO adm = null;
		
		if (cid.equals("") || cid == null) {
			return "f";
		}
		
		try {
			adm = admservice.get(cid);
			if(adm != null) {
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
