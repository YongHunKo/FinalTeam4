package com.multi.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.multi.dto.CustDTO;
import com.multi.service.CustService;
import com.multi.service.KaKaoService;



@Controller
@RequestMapping("/kakao")
public class KaKaoController {

	 @Autowired
	public KaKaoService kakao;
	 @Autowired
	 CustService custservice;
	
	 @RequestMapping(value="/callback")
	 public String login(@RequestParam("code") String code, HttpSession session,Model model) throws Exception {
		 String access_Token = kakao.getAccessToken(code);
		    HashMap<String, Object> userInfo = kakao.getUserInfo(access_Token);
//		    System.out.println("login Controller : " + userInfo); //나중에 막을것
		    model.addAttribute("userId", userInfo);
		    model.addAttribute("center", "kakaologout");
		    //    클라이언트의 이메일이 존재할 때 세션에 해당 이메일과 토큰 등록
//		    System.out.println(userInfo.get("nickname")); 확인용
		    String nickname = String.valueOf(userInfo.get("nickname"));
		    String email = String.valueOf(userInfo.get("email"));
//		    System.out.println(nickname); 확인용
//		    System.out.println(userInfo.get("email"));
		    if(custservice.get(email) != null) {
		    	if(custservice.get(email).getCustpwd().equals("1")) {
		    		session.setAttribute("logincust", custservice.get(email));
		    		model.addAttribute("center","maincenter");
		    	}
		    	
		    }else {
		    	try {
		    		custservice.register(new CustDTO(email, "1", nickname, null, null, null));
		    		session.setAttribute("logincust", custservice.get(email));
//		    		System.out.println("register_ok"); // 나중에 막을 것
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

	 @RequestMapping(value="/logout")
	 public String logout(HttpSession session) {
	     kakao.kakaoLogout((String)session.getAttribute("access_Token"));
	     session.removeAttribute("access_Token");
	     session.removeAttribute("userId");
	     return "index";
	 }


    }

    
    
    
	
 

