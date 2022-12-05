package com.multi.coupon;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.CouponDTO;
import com.multi.service.CouponService;

@SpringBootTest
class couponlist {
	@Autowired
	CouponService service;

	@Test
	void contextLoads() {
		 List<CouponDTO> couponlist = null;
		try {
			couponlist = service.couponlist("id02");
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (CouponDTO cl : couponlist) {
			System.out.println(cl);
		}
	}

}
