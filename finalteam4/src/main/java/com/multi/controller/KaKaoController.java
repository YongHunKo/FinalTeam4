package com.multi.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.multi.service.KaKaoService;



@Controller
@RequestMapping("/kakao")
public class KaKaoController {

	 @Autowired
	public KaKaoService kakao;
	
	 @RequestMapping(value="/callback")
	 public String login(@RequestParam("code") String code, HttpSession session) {
		 String access_Token = kakao.getAccessToken(code);
		    HashMap<String, Object> userInfo = kakao.getUserInfo(access_Token);
		    System.out.println("login Controller : " + userInfo);
		    
		    //    클라이언트의 이메일이 존재할 때 세션에 해당 이메일과 토큰 등록
		    if (userInfo.get("email") != null) {
		        session.setAttribute("userId", userInfo.get("email"));
		        session.setAttribute("access_Token", access_Token);
		    }
	 
		    	return "index";
	 }

	 		

    }

    
    
    
	
 

