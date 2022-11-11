package com.multi.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.EatAdmDTO;
import com.multi.service.EatAdmService;

@Controller
public class MainController {
	
	@Autowired
	EatAdmService admservice;
	
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
	
}
