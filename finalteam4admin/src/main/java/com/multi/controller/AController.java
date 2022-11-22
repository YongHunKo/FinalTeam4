package com.multi.controller;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multi.dto.ChartDTO;
import com.multi.dto.EatAdmDTO;
import com.multi.mapper.AMapper;
import com.multi.service.EatAdmService;

@RestController
public class AController {

	@Autowired
	EatAdmService admservice;
	@Autowired
	AMapper amapper;
	
	@RequestMapping("/checkid")
	public Object checkid(String cid) {
		String result = "";
		EatAdmDTO adm = null;
		
		if (cid.equals("") || cid == null) {
			return "f";
		}
		
		try {
			adm = admservice.get(cid);
			if(adm != null) {
				result = "f";
			}else {
				result = "t";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@RequestMapping("/chart1")
	public Object chart1() {
		JSONObject result = new JSONObject();
		
		JSONArray ja = new JSONArray();
		JSONObject obj = new JSONObject();
		obj.put("name", "Customer");
		
		JSONArray uja = new JSONArray();
		
		List<ChartDTO> list = null;
		
		list = amapper.chart1();
		
		JSONArray day_ja = new JSONArray();
		int d = 0;
		for(ChartDTO c:list) {
			uja.add(c.getTotal());
			d++;
			day_ja.add(d);	
		}
		obj.put("data", uja);
		ja.add(obj);
		
		result.put("day",day_ja);
		result.put("result", ja);
		return result;
	}
}
