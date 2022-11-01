package com.multi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.dto.ReserveDTO;
import com.multi.frame.MyService;
import com.multi.mapper.ReserveMapper;

@Service
public class ReserveService implements MyService<Integer,ReserveDTO> {

	@Autowired
	ReserveMapper mapper;
	
	
	@Override
	public void register(ReserveDTO v) throws Exception {
		mapper.insert(v);
		
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);
		
	}

	@Override
	public void modify(ReserveDTO v) throws Exception {
		mapper.update(v);
		
	}

	@Override
	public ReserveDTO get(Integer k) throws Exception {
		
		return mapper.select(k);
	}

	@Override
	public List<ReserveDTO> getall() throws Exception {
		
		return mapper.selectall();
	}

	public List<ReserveDTO> myreserve(String k) throws Exception {
		return mapper.myreserve(k);
	}
}
