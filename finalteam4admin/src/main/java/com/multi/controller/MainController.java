package com.multi.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.EatAdmDTO;
import com.multi.dto.MenuDTO;
import com.multi.service.EatAdmService;
import com.multi.service.MenuService;

@Controller
public class MainController {
	
	@Autowired
	EatAdmService admservice;
	@Autowired
	MenuService menuservice;
	
	@RequestMapping("/")
	public String main() {
		return "index";
	}
	
	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("center", "login");
		
		return "index";
	}
	
	@RequestMapping("/loginimpl")
	public String loginimpl(HttpSession session, String adminid, String pwd, Model model) {
		EatAdmDTO adm = null;
		try {
			adm = admservice.get(adminid);
			if(adm != null) {
				if(adm.getPwd().equals(pwd)) {
					session.setAttribute("loginadmin", adm);
				}else {
					model.addAttribute("center","loginfail");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		if(session != null) {
			session.invalidate();
		}
		return "index";
	}
	
	@RequestMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("center", "signup");
		return "index";
	}
	
	@RequestMapping("/signupimpl")
	public String signupimpl(Model model, EatAdmDTO adm, HttpSession session) {
		try {
			admservice.register(adm);
			session.setAttribute("loginadmin", adm);
			model.addAttribute("center", "maincenter");
			model.addAttribute("rid", adm);
		} catch (Exception e) {
			model.addAttribute("center", "signupfail");
			model.addAttribute("fid", adm.getAdminid());
		}
		return "index";
	}
	
	@RequestMapping("/menu")
	public String menu(Model model) {
		List<MenuDTO> list = null;
		try {
			list = menuservice.getall();
			model.addAttribute("list",list);
			model.addAttribute("center", "menu");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
}
