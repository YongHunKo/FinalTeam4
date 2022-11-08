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
import com.multi.service.NaverService;
import com.multi.service.StoreimgService;

@Controller
@RequestMapping("/naver")
public class NaverController {

	@Autowired
	NaverService naver;
	@Autowired
	CustService custservice;
	
	@Autowired
	StoreimgService imgservice;
	
	@RequestMapping(value="/callback")
	public String login(@RequestParam("code") String code, HttpSession session, Model model) throws Exception {
		String access_Token = naver.getAccessToken(code);
        System.out.println("controller access_token : " + access_Token);
       HashMap<String, Object> userInfo = naver.getUserInfo(access_Token);
       System.out.println("login Controller : " + userInfo);
       	List<StoreimgDTO> list2=null;
		List<StoreimgDTO> list3=null;
		list2=imgservice.selectrandom();
		list3=imgservice.selectrandominfo();
		model.addAttribute("randomimg", list2);
		model.addAttribute("randominfo", list3);
		
		model.addAttribute("naver", userInfo);
       model.addAttribute("center", "maincenter");
       
       String nickname = String.valueOf(userInfo.get("nickname"));
       String email = String.valueOf(userInfo.get("email"));
       String profile= String.valueOf(userInfo.get("profile"));
       if(custservice.get(email+"2") != null) {
	    	if(custservice.get(email+"2").getCustpwd().equals("2")) {
	    		session.setAttribute("logincust", custservice.get(email+"2"));
	    		model.addAttribute("center","maincenter");
	    	}
	    	
	    }else {
	    	try {
	    		custservice.register(new CustDTO(email+"2", "2", nickname, null, null, null, profile));
	    		session.setAttribute("logincust", custservice.get(email+"2"));
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	} 	
	    }
       
       if (userInfo.get("email") != null) {
           session.setAttribute("userId", userInfo.get("email"));
           session.setAttribute("access_Token", access_Token);
       }
       
       
	    return "index";
	
	}

	


}