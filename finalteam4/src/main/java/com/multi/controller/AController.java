package com.multi.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.multi.dto.CartDTO;
import com.multi.dto.CustDTO;
import com.multi.dto.StoreDTO;
import com.multi.frame.Util;
import com.multi.service.CartService;
import com.multi.service.CustService;
import com.multi.service.MenuService;
import com.multi.service.OcrService;
import com.multi.service.OrderlistService;
import com.multi.service.ReserveService;
import com.multi.service.StoreService;

@RestController
public class AController {

	@Autowired
	CustService cust_service;
	@Autowired
	CartService cartservice;
	@Autowired
	StoreService storeservice;
	@Autowired
	MenuService menuservice;
	@Autowired
	OrderlistService orderlistservice;
	@Autowired
	ReserveService reserveservice;
	@Autowired
	OcrService ocr;

	@Value("${imgdir}")
	String imgdir;

	/**
	 * checkid 해당 메소드는 cid를 통해 cust에서 해당 cid와 맞는 custid를 검색하여 일치 여부를 result로
	 * return해주기 위한 목적이다.
	 * 
	 * @param cid
	 * @return
	 */
	@RequestMapping("/checkid")
	public Object checkid(String cid) {
		String result = "";
		CustDTO cust = null;

		if (cid.equals("") || cid == null) {
			return "f";
		}

		try {
			cust = cust_service.get(cid);
			if (cust != null) {
				result = "f";
			} else {
				result = "t";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * addcart 해당 메소드는 storeid를 통해 store-menu-menuimgs로 묶인 관계에서 검색된 데이터들을 cart에
	 * register하는 것이 목적이다.
	 * 
	 * @param model
	 * @param custid
	 * @param cnt
	 * @param storeid
	 * @return
	 */
	@RequestMapping("/addcart")
	public String addcart(Model model, String custid, Integer cnt, Integer storeid) {
		List<StoreDTO> list = null;
		try {
			if (cartservice.selectcart(custid) != null) {
				cartservice.deletecart(custid);
			}
			list = storeservice.detail(storeid);
			for (StoreDTO s : list) {
				cartservice.register(new CartDTO(null, custid, s.getMenuid(), cnt, s.getMenuname(), s.getMenuprice(),
						s.getMenuimg(), (cnt * s.getMenuprice()),null,null));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * reconfirm 해당 메소드는 회원정보 수정에 관한 메소드이며 파라메터로 받아온 custid와 custpwd를 통해 cust에서 해당
	 * custid의 custpwd와 비교하여, 일치 여부를 result로 리턴시키는 것이 목적이다.
	 * 
	 * @param custid
	 * @param custpwd
	 * @return
	 */
	@RequestMapping("/edit/reconfirm")
	public Object reconfirm(String custid, String custpwd) {
		String result = "";
		String originpwd = "";
		CustDTO cust = null;

		try {
			cust = cust_service.get(custid);
			originpwd = cust.getCustpwd();

			if (originpwd.equals(custpwd)) {
				result = "true";
			} else {
				result = "false";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@RequestMapping("/ocr/ocrresult")
	public Object ocrresult(MultipartHttpServletRequest filelist) {
		Object obj = null;
		String fieldName = "";
		MultipartFile mfile = null;

		Iterator<String> iter = filelist.getFileNames();
		while (iter.hasNext()) {
			fieldName = (String) iter.next();
			mfile = filelist.getFile(fieldName);
			Util.saveFile(mfile, imgdir);
		}
		obj = ocr.ocrresult(mfile.getOriginalFilename());
		return obj;
	}
}
