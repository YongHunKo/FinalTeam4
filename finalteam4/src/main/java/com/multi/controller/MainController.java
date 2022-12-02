package com.multi.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.OrderlistDTO;
import com.multi.dto.StoreimgDTO;
import com.multi.dto.WishlistDTO;
import com.multi.service.OrderlistService;
import com.multi.service.StoreimgService;
import com.multi.service.WishlistService;

@Controller
public class MainController {

	@Autowired
	StoreimgService imgservice;
	@Autowired
	WishlistService wishservice;
	@Autowired
	OrderlistService orderservice;

	/**
	 * main 해당 메소드는 /로 이어지는 컨트롤러로 현재 로고에 사용되는 메소드이다. 
	 * 부가적으로 랜덤이미지, 랜덤정보가 출력된다. 
	 * 부가적으로 파라메터 id로 해당 id의 wishlist를 index에 출력해준다.
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/")
	public String main(Model model, String id, HttpSession session) {
		/* 랜덤이미지,랜덤정보 관련 list */
		List<StoreimgDTO> list2 = null;
		List<StoreimgDTO> list3 = null;
		List<StoreimgDTO> list4 = null;
		List<StoreimgDTO> list5 = null;
		List<StoreimgDTO> list6 = null;
		/* 위시리스트 관련 list */
		List<WishlistDTO> list7 = null;
		OrderlistDTO list8 = null;
		OrderlistDTO list9 = null;
		OrderlistDTO list10 = null;
		OrderlistDTO list11 = null;
		OrderlistDTO list12 = null;
		OrderlistDTO list13 = null;
		try {
			/* 랜덤이미지, 랜덤정보 관련 model */
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
			model.addAttribute("center", "maincenter");
			/* 위시리스트 관련 model */
			list7 = wishservice.viewwish(id);
			list8 = orderservice.myorder_1(id);
			list9 = orderservice.ranking();
			list10 = orderservice.ranking2();
			list11 = orderservice.ranking3();
			list12 = orderservice.ranking4();
			list13 = orderservice.ranking5();
			model.addAttribute("viewwish", list7);
			model.addAttribute("list_one", list8);
			session.setAttribute("ranking", list9);
			session.setAttribute("ranking2", list10);
			session.setAttribute("ranking3", list11);
			session.setAttribute("ranking4", list12);
			session.setAttribute("ranking5", list13);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}

	/**
	 * login
	 * 해당 메소드는 login.html을 연결해주는 메소드이다.
	 * @param model
	 * @return
	 */
	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("center", "login");
		return "index";
	}
	
	/**
	 * wishlist
	 * 해당 메소드는 파라메터 id의 wishlist를
	 * 출력하기 위한 메소드이다.
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/wishlist")
	public String wishlist(String id, Model model) {
		List<WishlistDTO> list = null;
		try {
			list = wishservice.viewwish(id);
			model.addAttribute("viewwish", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("center", "wishlist");
		return "index";
	}

	/**
	 * deletewishlist
	 * 해당 메소드는 wishlist에 있는
	 * 파라메터 wishlistid를 통해 delete하는 것이 목적이다.
	 * @param model
	 * @param wishlistid
	 * @param id
	 * @return
	 */
	@RequestMapping("/deletewishlist")
	public String deletewishlist(Model model, int wishlistid, String id) {
		try {
			wishservice.remove(wishlistid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/wishlist?id=" + id;
	}
	
	/**
	 * websocket 해당 메소드는 websocket.html로 이동하는 메소드이다.
	 * @param model
	 * @return
	 */
	@RequestMapping("/websocket")
	public String websocket(Model model) {
		model.addAttribute("center", "websocket");
		return "index";
	}

}
