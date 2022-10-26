package com.multi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.dto.StoreDTO;
import com.multi.frame.MyService;
import com.multi.mapper.StoreMapper;
@Service
public class StoreService implements MyService<Integer, StoreDTO>{
	@Autowired
	StoreMapper mapper;

	@Override
	public void register(StoreDTO v) throws Exception {
		mapper.insert(v);		
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);		
	}

	@Override
	public void modify(StoreDTO v) throws Exception {
		mapper.update(v);		
	}

	@Override
	public StoreDTO get(Integer k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<StoreDTO> getall() throws Exception {
		return mapper.selectall();
	}

}
