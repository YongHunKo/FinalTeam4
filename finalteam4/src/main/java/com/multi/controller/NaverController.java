package com.multi.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.multi.service.NaverService;

@Controller
@RequestMapping("/naver")
public class NaverController {

	@Autowired
	NaverService naver;
	
	@RequestMapping(value="/callback")
	public String login(@RequestParam("code") String code, HttpSession session, Model model) {
		String access_Token = naver.getAccessToken(code);
        System.out.println("controller access_token : " + access_Token);
       HashMap<String, Object> userInfo = naver.getUserInfo(access_Token);
       System.out.println("login Controller : " + userInfo);
	    
       model.addAttribute("naver", userInfo);
       model.addAttribute("center", "naverlogout");
       
       
       if (userInfo.get("email") != null) {
           session.setAttribute("userId", userInfo.get("email"));
           session.setAttribute("access_Token", access_Token);
       }
       
       
	    return "index";
	
	}

	



}