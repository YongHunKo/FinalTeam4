package com.multi.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.multi.service.OauthService;

@Controller
@RequestMapping("/google")
public class OauthController {
    
	@Autowired
	OauthService google;

	@RequestMapping(value="/callback")
	public void  googleLogin(@RequestParam("code") String code, HttpSession session) {
			 String access_Token = google.getGoogleAccessToken(code);
			    HashMap<String, Object> userInfo = google.getGoogleUserInfo(access_Token);
			    System.out.println("login Controller : " + userInfo);
   


	  
	}	

}