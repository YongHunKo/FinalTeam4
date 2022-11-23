package com.multi.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.CustDTO;
import com.multi.dto.EatAdmDTO;
import com.multi.dto.MenuDTO;
import com.multi.dto.MenuimgDTO;
import com.multi.dto.StoreDTO;
import com.multi.dto.StoreimgDTO;
import com.multi.frame.Util;
import com.multi.service.CustService;
import com.multi.service.EatAdmService;
import com.multi.service.MenuService;
import com.multi.service.MenuimgService;
import com.multi.service.StoreService;
import com.multi.service.StoreimgService;

@Controller
public class MainController {
	
	@Value("${adminstore}")
	String adminstore;
	@Value("${custstore}")
	String custstore;
	@Value("${adminmenu}")
	String adminmenu;
	@Value("${custmenu}")
	String custmenu;
	@Autowired
	EatAdmService admservice;
	@Autowired
	MenuService menuservice;
	@Autowired
	StoreService storeservice;
	@Autowired
	StoreimgService storeimgservice;
	@Autowired
	MenuimgService menuimgservice;
	@Autowired
	CustService custservice;
	
	@RequestMapping("/")
	public String main() {
		return "index";
	}
	
	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("center", "login");
		
		return "index";
	}
	
	@RequestMapping("/websocket")
	public String websocket(Model model) {
		model.addAttribute("center", "websocket");
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
	
	@RequestMapping("/store")
	public String store(Model model) {
		List<StoreDTO> list = null;
		try {
			list = storeservice.getall();
			model.addAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("center", "store");
		return "index";
	}
	
	@RequestMapping("/deletestore")
	public String deletestore(Model model, int storeid) {
		try {
			storeservice.remove(storeid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/store";
	}	
	
	@RequestMapping("/registerstore")
	public String registerstore(Model model) {
		model.addAttribute("center", "registerstore");
		return "index";
	}
	
	@RequestMapping("/registerstoreimgimpl")
	public String registerstoreimgimpl(Model model, StoreimgDTO sto) {
		String storeimg = sto.getSimg().getOriginalFilename();
		sto.setStoreimg(storeimg);
		try {
			Util.saveFile(sto.getSimg(), adminstore, custstore);
			storeimgservice.register(sto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/storeimg";
	}
	
	@RequestMapping("/updatestore")
	public String updatestore(Model model) {
		model.addAttribute("center", "updatestore");
		return "index";
	}
	
	@RequestMapping("/updatestoreimpl")
	public String updatestoreimpl(Model model, StoreDTO sto) {
		try {
			storeservice.modify(sto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/store";
	}
	
	@RequestMapping("/storeimg")
	public String storeimg(Model model) {
		List<StoreimgDTO> list = null;
		try {
			list = storeimgservice.getall();
			model.addAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("center", "storeimg");
		return "index";
	}
	
	@RequestMapping("/deletestoreimg")
	public String deletestoreimg(Model model, int storeimgno) {
		try {
			storeimgservice.remove(storeimgno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/storeimg";
	}
	
	@RequestMapping("/registerstoreimg")
	public String registerimg(Model model) {
		model.addAttribute("center", "registerstoreimg");
		return "index";
	}
	
	@RequestMapping("/menu")
	public String menu(Model model) {
		List<MenuDTO> list = null;
		try {
			list = menuservice.getall();
			model.addAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("center", "menu");
		return "index";
	}
	
	@RequestMapping("/deletemenu")
	public String deletemenu(Model model, int menuid) {
		try {
			menuservice.remove(menuid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/menu";
	}	
	
	@RequestMapping("/regmenu")
	public String regmenu(Model model) {
		model.addAttribute("center", "regmenu");
		return "index";
	}
	
	@RequestMapping("/regmenuimpl")
	public String regmenuimpl(Model model, MenuDTO menu) {
		try {
			menuservice.register(menu);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/menu";
	}
	
	@RequestMapping("/updatemenu")
	public String updatemenu(Model model) {
		model.addAttribute("center", "updatemenu");
		return "index";
	}
	
	@RequestMapping("/updatemenuimpl")
	public String updatemenuimpl(Model model, MenuDTO menu) {
		try {
			menuservice.modify(menu);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/menu";
	}
	
	@RequestMapping("/menuimg")
	public String menuimg(Model model) {
		List<MenuimgDTO> list = null;
		try {
			list = menuimgservice.getall();
			model.addAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("center", "menuimg");
		return "index";
	}
	
	@RequestMapping("/deletemenuimg")
	public String deletemenuimg(Model model, int menuimgno) {
		try {
			menuimgservice.remove(menuimgno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/menuimg";
	}	
	
	@RequestMapping("/regmenuimg")
	public String regmenuimg(Model model) {
		model.addAttribute("center", "regmenuimg");
		return "index";
	}
	
	@RequestMapping("/regmenuimgimpl")
	public String regmenuimgimpl(Model model, MenuimgDTO menu) {
		String menuimg = menu.getMimg().getOriginalFilename();
		menu.setMenuimg(menuimg);
		try {
			Util.saveFile(menu.getMimg(), adminmenu, custmenu);
			menuimgservice.register(menu);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/menuimg";
	}
	
	@RequestMapping("/user")
	public String user(Model model) {
		List<CustDTO> list = null;
		try {
			list = custservice.getall();
			model.addAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("center", "user");
		return "index";
	}
	
	@RequestMapping("/deleteuser")
	public String deleteuser(Model model, String custid) {
		try {
			custservice.remove(custid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/user";
	}	
	
	@RequestMapping("/storesales")
	public String storesales(Model model) {
		model.addAttribute("center", "storesales");
		return "index";
	}
}
