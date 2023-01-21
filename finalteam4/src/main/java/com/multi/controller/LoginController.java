package com.multi.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.CustDTO;
import com.multi.dto.OrderlistDTO;
import com.multi.dto.StoreimgDTO;
import com.multi.dto.WishlistDTO;
import com.multi.service.CustService;
import com.multi.service.OrderlistService;
import com.multi.service.StoreimgService;
import com.multi.service.WishlistService;

@Controller
public class LoginController {

	@Autowired
	CustService service;
	@Autowired
	WishlistService wishservice;
	@Autowired
	StoreimgService imgservice;
	@Autowired
	OrderlistService orderservice;
	
	/**
	 * logout
	 * 단순히 session의 값이 존재할 때,
	 * session을 invalidate하여 값을 없애며
	 * 정상적으로 logout하는 것이 목적이다.
	 * 부가적으로 랜덤이미지, 랜덤정보를
	 * 메인센터에 뿌리도록 한다
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session,Model model) {
		List<StoreimgDTO> list2=null;
		List<StoreimgDTO> list3=null;
		List<StoreimgDTO> list4=null;
		List<StoreimgDTO> list5=null;
		List<StoreimgDTO> list6=null;
		try {
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
	     	model.addAttribute("center","maincenter");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		if (session != null) {
			session.removeAttribute("logincust");;
		}
		return "index";
	}
	/**
	 * loginimpl
	 * 파라메터로 받아온 custid, custpwd를 사용하여
	 * custid로 cust를 조회하여
	 * 값이 있을 경우는 조회한 cust의 custpwd와
	 * 파라메터로 받아온 custpwd를 비교하여
	 * 일치하면 logincust에 cust를 담아서
	 * maincenter에 뿌려주는 것이 목적
	 * 부가적으로 랜덤이미지, 랜덤정보를
	 * 메인센터에 뿌리도록 한다.
	 * 부가적으로 로그인이 성공하면 custid를 이용하여
	 * viewwish를 조회하여
	 * 메인센터에 뿌리도록 한다.
	 * @param session
	 * @param custid
	 * @param custpwd
	 * @param model
	 * @return
	 */
	@RequestMapping("/loginimpl")
	public String loginimpl(HttpSession session, String custid, String custpwd, Model model) {
		CustDTO cust = null;
		List<StoreimgDTO> list2=null;
		List<StoreimgDTO> list3=null;
		List<StoreimgDTO> list4=null;
		List<StoreimgDTO> list5=null;
		List<StoreimgDTO> list6=null;		
		try {
			cust = service.get(custid);
			list2=imgservice.selectrandom();
			list3=imgservice.selectrandominfo();
			list4 = imgservice.today();
			list5 = imgservice.today2();
			list6 = imgservice.today3();
			if(cust != null) {
				if(cust.getCustpwd().equals(custpwd)) {	
				session.setAttribute("logincust", cust);
				model.addAttribute("center", "maincenter");
				model.addAttribute("randomimg", list2);
				model.addAttribute("randominfo", list3);
				model.addAttribute("today", list4);
				model.addAttribute("todaytwo", list5);
				model.addAttribute("todaythree", list6);
				}else {
					model.addAttribute("center", "loginfail");
				}
				List<WishlistDTO> list = null;
				list = wishservice.viewwish(custid);
				model.addAttribute("viewwish", list);
			}
		} catch (Exception e) {			
		}
		OrderlistDTO list9 = null;
		OrderlistDTO list10 = null;
		OrderlistDTO list11 = null;
		OrderlistDTO list12 = null;
		OrderlistDTO list13 = null;
		try {
			list9 = orderservice.ranking();
			list10 = orderservice.ranking2();
			list11 = orderservice.ranking3();
			list12 = orderservice.ranking4();
			list13 = orderservice.ranking5();
			model.addAttribute("ranking", list9);
			model.addAttribute("ranking2", list10);
			model.addAttribute("ranking3", list11);
			model.addAttribute("ranking4", list12);
			model.addAttribute("ranking5", list13);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "index";
	}	
}
