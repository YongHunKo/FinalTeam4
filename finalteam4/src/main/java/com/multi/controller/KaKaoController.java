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
import com.multi.service.KaKaoService;
import com.multi.service.StoreimgService;



@Controller
@RequestMapping("/kakao")
public class KaKaoController {

	 @Autowired
	public KaKaoService kakao;
	 @Autowired
	 CustService custservice;
	 
	 @Autowired
	 StoreimgService imgservice;
	
	 @RequestMapping(value="/callback")
	 public String login(@RequestParam("code") String code, HttpSession session,Model model) throws Exception {
		 String access_Token = kakao.getAccessToken(code);
		    HashMap<String, Object> userInfo = kakao.getUserInfo(access_Token);
		    List<StoreimgDTO> list2=null;
		    List<StoreimgDTO> list3=null;
		    list2 = imgservice.selectrandom();
		    list3 = imgservice.selectrandominfo();
//		    System.out.println("login Controller : " + userInfo); //나중에 막을것
		    model.addAttribute("userId", userInfo);
		    model.addAttribute("center", "maincenter");
		    //    클라이언트의 이메일이 존재할 때 세션에 해당 이메일과 토큰 등록
//		    System.out.println(userInfo.get("nickname")); 확인용
		    String nickname = String.valueOf(userInfo.get("nickname"));
		    String email = String.valueOf(userInfo.get("email"));
		    String profile =String.valueOf(userInfo.get("profile"));
//		    System.out.println(nickname); 확인용
//		    System.out.println(userInfo.get("email"));
		    if(custservice.get(email+"1") != null) {
		    	if(custservice.get(email+"1").getCustpwd().equals("1")) {
		    		session.setAttribute("logincust", custservice.get(email+"1"));
		    		model.addAttribute("center","maincenter");
		    		model.addAttribute("randomimg", list2);
		    		model.addAttribute("randominfo", list3);
		    	}
		    	
		    }else {
		    	try {
		    		custservice.register(new CustDTO(email+"1", "1", nickname, null, null, null,profile));
		    		session.setAttribute("logincust", custservice.get(email+"1"));
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
	 public String logout(HttpSession session, Model model) throws Exception {
		 	List<StoreimgDTO> list2=null;
		    List<StoreimgDTO> list3=null;
		    list2 = imgservice.selectrandom();
		    list3 = imgservice.selectrandominfo();
	     kakao.kakaoLogout((String)session.getAttribute("access_Token"));
	     	model.addAttribute("randomimg", list2);
	     	model.addAttribute("randominfo", list3);
	     	model.addAttribute("center","maincenter");
	     
	     session.removeAttribute("access_Token");
	     session.removeAttribute("userId");
	     return "index";
	 }


    }

    
    
    
	
 

