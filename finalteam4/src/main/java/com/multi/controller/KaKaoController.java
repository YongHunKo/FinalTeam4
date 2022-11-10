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
	
	 /**
	  * kakaologin
	  * 해당 메소드는  oauth를 기반으로한
	  * accessToken을 통해 카카오서버에서 인증허가토큰을통해 유저DB를 받아오고
	  * HashMap으로 키값은 String, value값은 JSONObject로 userInfo에 담아서
	  * userInfo에 담긴 값들을 추출하여 
	  * cust에 해당 카카오로그인 데이터가 없을 시 register,
	  * cust에 해당 카카오로그인 데이터가 있을 시 일반적인 로그인방식으로
	  * 쉽게 로그인하는 것이 목적이다.
	  * 부가적으로 해당유저의 프로필이미지,유저네임을 출력할수있도록 값을 추출한다.
	  * @param code
	  * @param session
	  * @param model
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping(value="/callback")
	 public String login(@RequestParam("code") String code, HttpSession session,Model model) throws Exception {
		String access_Token = kakao.getAccessToken(code);
	    HashMap<String, Object> userInfo = kakao.getUserInfo(access_Token);
	    
	    /*랜덤이미지, 랜덤정보 부분*/
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
	    
	    /*소셜로그인 데이터를 userInfo에 담아서 추출하는 부분*/
	    model.addAttribute("userId", userInfo);
	    model.addAttribute("center", "maincenter");
	    String nickname = String.valueOf(userInfo.get("nickname"));
	    String email = String.valueOf(userInfo.get("email"));
	    String profile =String.valueOf(userInfo.get("profile"));
	    
	    /*소셜로그인을 하는 부분*/
		/*여기서 "1"값을 준 이유는 네이버 소셜로그인과 동일한 계정을 등록하지 않기 위함이다*/
	    if(custservice.get(email+"1") != null) {
	    	if(custservice.get(email+"1").getCustpwd().equals("1")) {
	    		session.setAttribute("logincust", custservice.get(email+"1"));
	    		model.addAttribute("center","maincenter");
	    	}
	    }else {
	    	try {
	    		custservice.register(new CustDTO(email+"1", "1", nickname, null, null, null,profile));
	    		session.setAttribute("logincust", custservice.get(email+"1"));
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	} 	
	    }
	    
	    /*소셜로그인을 로그아웃하도록 하는 session저장 하는 부분*/
	    if (userInfo.get("email") != null) {
	        session.setAttribute("userId", userInfo.get("email"));
	        session.setAttribute("access_Token", access_Token);
	    }
	    return "index";
	 }

	 /**
	  * 소셜logout
	  * 해당 메소드는 기본적인 로그아웃과 같지만
	  * 소셜login 작동시 session에 저장했던
	  * userId와 access_Token을 이용하여
	  * 로그아웃을 하는 것이 목적이다.
	  * 부가적으로 랜덤이미지,랜점정보가 출력된다.
	  * @param session
	  * @param model
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping(value="/logout")
	 public String logout(HttpSession session, Model model) throws Exception {
		 /*랜덤이미지, 랜덤정보 부분*/
		 List<StoreimgDTO> list2=null;
		 List<StoreimgDTO> list3=null;
		 list2 = imgservice.selectrandom();
		 list3 = imgservice.selectrandominfo();
		 model.addAttribute("randomimg", list2);
		 model.addAttribute("randominfo", list3);
		 model.addAttribute("center","maincenter");
		 
		 /*소셜로그인을 로그아웃하도록 하는 session을 이용하는 부분*/
		 kakao.kakaoLogout((String)session.getAttribute("access_Token"));
		 session.removeAttribute("access_Token");
		 session.removeAttribute("userId");
		 return "index";
		 }
}

    
    
    
	
 

