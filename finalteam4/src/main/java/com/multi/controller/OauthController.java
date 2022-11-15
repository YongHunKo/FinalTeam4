package com.multi.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.multi.dto.CustDTO;
import com.multi.dto.StoreimgDTO;
import com.multi.service.CustService;
import com.multi.service.OauthService;
import com.multi.service.StoreimgService;

@Controller
@RequestMapping("/google")
public class OauthController {
    
	@Autowired
	OauthService google;

	 @Autowired
	 CustService custservice;
	 @Autowired
	 StoreimgService imgservice;
	
	
	@RequestMapping(value="/callback")
	public String googleLogin(@RequestParam("code") String code, HttpSession session,Model model) throws Exception {
			 String access_Token = google.getGoogleAccessToken(code);
			    HashMap<String, Object> userInfo = google.getGoogleUserInfo(access_Token);
			    System.out.println("login Controller : " + userInfo);
			    model.addAttribute("center", "maincenter");
			    List<StoreimgDTO> list2=null;
			    List<StoreimgDTO> list3=null;
				List<StoreimgDTO> list4=null;
				List<StoreimgDTO> list5=null;
				List<StoreimgDTO> list6=null;
			    list2 = imgservice.selectrandom();
			    list3 = imgservice.selectrandominfo();
			    list4 = imgservice.today();
				list5 = imgservice.today2();
				list6 = imgservice.today3();
			    model.addAttribute("randomimg", list2);
			    model.addAttribute("randominfo", list3);
			    model.addAttribute("today", list4);
				model.addAttribute("todaytwo", list5);
				model.addAttribute("todaythree", list6);
				
				String name = String.valueOf(userInfo.get("name"));
				String email = String.valueOf(userInfo.get("email"));
				String profile =String.valueOf(userInfo.get("profile"));
				
				System.out.println(name);
				System.out.println(profile);
				System.out.println(email);
			
				  if(custservice.get(email+"1") != null) {
				    	if(custservice.get(email+"1").getCustpwd().equals("1")) {
				    		session.setAttribute("logincust", custservice.get(email+"1"));
				    		model.addAttribute("center","maincenter");
				    	}
				    }else {
				    	try {
				    		custservice.register(new CustDTO(email+"1", "1", name, null, null, null,profile));
				    		session.setAttribute("logincust", custservice.get(email+"1"));
				    	} catch (Exception e) {
				    		e.printStackTrace();
				    	} 

	  
			    }	
				  return "index";
 }
}