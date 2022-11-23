package com.multi.chart;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.ChartDTO;
import com.multi.mapper.AMapper;

@SpringBootTest
class Finalteam4adminApplicationTests {
	@Autowired
	AMapper amapper;

	@Test
	void contextLoads() {
JSONObject result = new JSONObject();
		
		JSONArray ja = new JSONArray();
		JSONObject obj = new JSONObject();
		
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
		System.out.println(result);
	}

}
