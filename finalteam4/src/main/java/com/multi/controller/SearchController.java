package com.multi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.MenuDTO;
import com.multi.dto.StoreDTO;
import com.multi.service.MenuService;
import com.multi.service.StoreService;

@Controller
public class SearchController {

	@Autowired
	MenuService menuservice;
	@Autowired
	StoreService storeservice;

	/**
	 * searchimpl 해당 메소드는 파라메터 txt값을 이용하여 메뉴, 가게이름을 찾기 위한 목적이다.
	 * 
	 * @param model
	 * @param txt
	 * @return
	 */
	@RequestMapping("/searchimpl")
	public String searchimpl(Model model, String txt) {
		List<MenuDTO> list = null;
		try {
			list = menuservice.searchmenu(txt);
			model.addAttribute("menulist", list);
			model.addAttribute("page", "/searchimpl");
			model.addAttribute("center", "search");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
	
	@RequestMapping("/searchimpl2")
	public String searchimpl2(Model model, String txt) {
		List<MenuDTO> list = null;
		try {
			list = menuservice.searchmenu2(txt);
			model.addAttribute("menulist", list);
			model.addAttribute("page", "/searchimpl2");
			model.addAttribute("center", "search");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
	@RequestMapping("/searchimpl3")
	public String searchimpl3(Model model, String txt) {
		List<MenuDTO> list = null;
		try {
			list = menuservice.searchmenu3(txt);
			model.addAttribute("menulist", list);
			model.addAttribute("page", "/searchimpl3");
			model.addAttribute("center", "search");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
	@RequestMapping("/searchimpl4")
	public String searchimpl4(Model model, String txt) {
		List<MenuDTO> list = null;
		try {
			list = menuservice.searchmenu4(txt);
			model.addAttribute("menulist", list);
			model.addAttribute("page", "/searchimpl4");
			model.addAttribute("center", "search");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
	
	@RequestMapping("/searchimpl/desc")
	public String desc(Model model, String txt) {
		List<MenuDTO> list = null;
		try {
			list = menuservice.searchmenudesc(txt);
			model.addAttribute("menulist", list);
			model.addAttribute("page", "/searchimpl");
			model.addAttribute("center", "search");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
	
	@RequestMapping("/searchimpl/asc")
	public String asc(Model model, String txt) {
		List<MenuDTO> list = null;
		try {
			list = menuservice.searchmenuasc(txt);
			model.addAttribute("menulist", list);
			model.addAttribute("page", "/searchimpl");
			model.addAttribute("center", "search");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
	
	@RequestMapping("/searchimpl2/desc")
	public String desc2(Model model, String txt) {
		List<MenuDTO> list = null;
		try {
			list = menuservice.searchmenu2desc(txt);
			model.addAttribute("menulist", list);
			model.addAttribute("page", "/searchimpl2");
			model.addAttribute("center", "search");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
	
	@RequestMapping("/searchimpl2/asc")
	public String asc2(Model model, String txt) {
		List<MenuDTO> list = null;
		try {
			list = menuservice.searchmenu2asc(txt);
			model.addAttribute("menulist", list);
			model.addAttribute("page", "/searchimpl2");
			model.addAttribute("center", "search");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
	
	@RequestMapping("/searchimpl3/desc")
	public String desc3(Model model, String txt) {
		List<MenuDTO> list = null;
		try {
			list = menuservice.searchmenu3desc(txt);
			model.addAttribute("menulist", list);
			model.addAttribute("page", "/searchimpl3");
			model.addAttribute("center", "search");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
	
	@RequestMapping("/searchimpl3/asc")
	public String asc3(Model model, String txt) {
		List<MenuDTO> list = null;
		try {
			list = menuservice.searchmenu3asc(txt);
			model.addAttribute("menulist", list);
			model.addAttribute("page", "/searchimpl3");
			model.addAttribute("center", "search");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
	
	@RequestMapping("/searchimpl4/desc")
	public String desc4(Model model, String txt) {
		List<MenuDTO> list = null;
		try {
			list = menuservice.searchmenu4desc(txt);
			model.addAttribute("menulist", list);
			model.addAttribute("page", "/searchimpl4");
			model.addAttribute("center", "search");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
	
	@RequestMapping("/searchimpl4/asc")
	public String asc4(Model model, String txt) {
		List<MenuDTO> list = null;
		try {
			list = menuservice.searchmenu4asc(txt);
			model.addAttribute("menulist", list);
			model.addAttribute("page", "/searchimpl4");
			model.addAttribute("center", "search");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
}
