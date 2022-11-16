package com.multi.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.CustDTO;
import com.multi.dto.OrderlistDTO;
import com.multi.dto.ReserveDTO;
import com.multi.dto.ReviewDTO;
import com.multi.service.CustService;
import com.multi.service.OrderlistService;
import com.multi.service.ReserveService;
import com.multi.service.ReviewService;
import com.multi.service.WishlistService;

@Controller
@RequestMapping("/mypage")
public class MyPageController {

	@Autowired
	CustService cust_service;
	@Autowired
	OrderlistService order_service;
	@Autowired
	ReviewService review_service;
	@Autowired
	ReserveService reserve_service;
	@Autowired
	WishlistService wishservice;

	String dir = "mypage/";

	/**
	 * mypage
	 * 해당 메소드는 mypage를 연결하기 위한 메소드이다.
	 * 해당 메소드가 발동하면 mypage에는 orderlist에
	 * 파라메터 id와 일치하는 custid의 DTO들을 
	 * list_one에 저장하여 mypage에 출력한다.
	 * 이 컨트롤러에서는 String dir을 설정하였기 때문에
	 * dir 입력시 조심하여야한다.
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("")
	public String mypage(String id, Model model) {
		OrderlistDTO list_one = null;
		try {
			list_one = order_service.myorder_1(id);
			model.addAttribute("list_one", list_one);
			model.addAttribute("center", dir + "mypage");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}

	/**
	 * order
	 * 해당 메소드는 중복같은데
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/order")
	public String order(String id, Model model) {
		OrderlistDTO list_one = null;
		List<OrderlistDTO> list = null;
		try {
			list_one = order_service.myorder_1(id);
			list = order_service.myorder(id);
			model.addAttribute("list_one", list_one);
			model.addAttribute("orderlist", list);
			model.addAttribute("center", dir + "order");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}

	/**
	 * orderdetail
	 * 해당 메소드는 session의 저장된 logincust를 obj에 저장하고,
	 * obj를 CustDTO에 담아서 custid를 추출하여
	 * 해당 custid의 주문내역과 파라메터 id의 예약내역을 각각의 list에 담아
	 * orderdetail에 출력을 해주는 목적이다.
	 * @param id
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/orderdetail")
	public String orderdetail(Integer id, Model model, HttpSession session) {
		Object obj = session.getAttribute("logincust");
		CustDTO cust = (CustDTO) obj;
		String custid = cust.getCustid();

		OrderlistDTO list_one = null;
		List<ReserveDTO> list = null;
		ReserveDTO rv = null;
		int cnt = 0;
		int total = 0;
		try {
			list_one = order_service.myorder_1(custid);
			list = reserve_service.myreserve(id);
			rv = list.get(0);
			for (ReserveDTO r : list) {
				cnt += r.getCnt();
				total += r.getOrderprice();
			}
			model.addAttribute("list_one", list_one);
			model.addAttribute("list", list);
			model.addAttribute("rvdto", rv);
			model.addAttribute("cnt", cnt);
			model.addAttribute("total", total);
			model.addAttribute("center", dir + "orderdetail");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}

	/**
	 * ocr
	 * 작업중
	 * @param id
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/ocr")
	public String ocr(Integer id, Model model, HttpSession session) {
		Object obj = session.getAttribute("logincust");
		CustDTO cust = (CustDTO) obj;
		String custid = cust.getCustid();

		OrderlistDTO list_one = null;
		List<ReserveDTO> list = null;
		ReserveDTO rv = null;
		int total = 0;
		try {
		list_one = order_service.myorder_1(custid);
		list = reserve_service.myreserve(id);
		rv = list.get(0);
		for (ReserveDTO r : list) {
			total += r.getOrderprice();
		}
			model.addAttribute("list_one", list_one);
			model.addAttribute("list", list);
			model.addAttribute("order", rv);
			model.addAttribute("total", total);
			model.addAttribute("center", dir + "ocr");
		} catch (Exception e) {
			e.printStackTrace();
		}
//		System.out.println(rv.getStorename());
		return "index";
	}

	/**
	 * review
	 * 해당 메소드는 파라메터id의 review 내용을
	 * review페이지에 출력하는 목적이다.
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/review")
	public String review(String id, Model model) {
		OrderlistDTO list_one = null;
		List<ReviewDTO> review = null;
		try {
			list_one = order_service.myorder_1(id);
			review = review_service.myreview(id);
			model.addAttribute("list_one", list_one);
			model.addAttribute("review", review);
			model.addAttribute("center", dir + "review");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(review);
		return "index";
	}

	/**
	 * edit
	 * 해당 메소드는 edit페이지를 가기 위한 메소드이다.
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/edit")
	public String edit(String id, Model model) {
		OrderlistDTO list_one = null;
		try {
			list_one = order_service.myorder_1(id);
			model.addAttribute("list_one", list_one);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("center", dir + "edit");
		return "index";
	}

	/**
	 * info
	 * 해당 메소드는 info페이지를 가기 위한 메소드이다.
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/info")
	public String info(String id, Model model) {
		OrderlistDTO list_one = null;
		try {
			list_one = order_service.myorder_1(id);
			model.addAttribute("list_one", list_one);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("center", dir + "info");
		return "index";
	}
	
	@RequestMapping("/update")
	public String update(CustDTO cust, Model model, HttpSession session) {
		CustDTO logincust = (CustDTO) session.getAttribute("logincust");
		cust.setCustrdate(logincust.getCustrdate());
		cust.setBirth(logincust.getBirth());
		cust.setProfileimg(logincust.getProfileimg());
		try {
			cust_service.modify(cust);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/mypage?id=" + cust.getCustid();
	}

}
