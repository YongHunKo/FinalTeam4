package com.multi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.dto.CouponDTO;
import com.multi.frame.MyService;
import com.multi.mapper.CouponMapper;
@Service
public class CouponService implements MyService<Integer, CouponDTO>{

	@Autowired
	CouponMapper mapper;
	
	@Override
	public void register(CouponDTO v) throws Exception {
		mapper.insert(v);		
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);
		
	}

	@Override
	public void modify(CouponDTO v) throws Exception {
		mapper.update(v);
		
	}

	@Override
	public CouponDTO get(Integer k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CouponDTO> getall() throws Exception {
		return mapper.selectall();
	}
	
	public List<CouponDTO> couponlist(String k) throws Exception {
		return mapper.couponlist(k);
	}

}
