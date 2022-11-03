package com.multi.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.multi.service.NaverService;

@Controller
@RequestMapping("/naver")
public class NaverController {

	@Autowired
	NaverService naver;
	
	@RequestMapping(value="/callback")
	public String login(@RequestParam("code") String code) {
		String access_Token = naver.getAccessToken(code);
        System.out.println("controller access_token : " + access_Token);
//        HashMap<String, Object> userInfo = naver.getUserInfo(access_Token);
//        System.out.println("login Controller : " + userInfo);
	    
	    return "index";
	
	}

	



}