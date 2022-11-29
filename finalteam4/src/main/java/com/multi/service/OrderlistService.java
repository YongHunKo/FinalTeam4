package com.multi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.dto.OrderlistDTO;
import com.multi.frame.MyService;
import com.multi.mapper.OrderlistMapper;
@Service
public class OrderlistService implements MyService<Integer, OrderlistDTO>{

	@Autowired
	OrderlistMapper mapper;
	
	@Override
	public void register(OrderlistDTO v) throws Exception {
		mapper.insert(v);		
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);		
	}

	@Override
	public void modify(OrderlistDTO v) throws Exception {
		mapper.update(v);		
	}

	@Override
	public OrderlistDTO get(Integer k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<OrderlistDTO> getall() throws Exception {
		return mapper.selectall();
	}
	
	public OrderlistDTO myorder_1(String k) throws Exception {
		return mapper.myorder_1(k);
	}

	public List<OrderlistDTO> myorder(String k) throws Exception {
		return mapper.myorder(k);
	}
	
	public OrderlistDTO ranking() throws Exception {
		return mapper.ranking();
	}
	
	public OrderlistDTO ranking2() throws Exception {
		return mapper.ranking2();
	}
	
	public OrderlistDTO ranking3() throws Exception {
		return mapper.ranking3();
	}
	
	public OrderlistDTO ranking4() throws Exception {
		return mapper.ranking4();
	}
	
	public OrderlistDTO ranking5() throws Exception {
		return mapper.ranking5();
	}
	
	public OrderlistDTO total_pay(String k) throws Exception {
		return mapper.total_pay(k);
	}
}
