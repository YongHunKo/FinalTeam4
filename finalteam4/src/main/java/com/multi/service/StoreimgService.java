package com.multi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.dto.StoreimgDTO;
import com.multi.frame.MyService;
import com.multi.mapper.StoreimgMapper;

@Service
public class StoreimgService implements MyService<Integer, StoreimgDTO>{
	
	@Autowired
	StoreimgMapper mapper;
	@Override
	public void register(StoreimgDTO v) throws Exception {
		mapper.insert(v);		
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);		
	}

	@Override
	public void modify(StoreimgDTO v) throws Exception {
		mapper.update(v);		
	}

	@Override
	public StoreimgDTO get(Integer k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<StoreimgDTO> getall() throws Exception {
		return mapper.selectall();
	}
	
	public List<StoreimgDTO> selectstoreid(Integer storeid) throws Exception{
		return mapper.selectstoreid(storeid);
	}

	public List<StoreimgDTO>  selectrandom() throws Exception{
		return mapper.selectrandom();
	}


	public List<StoreimgDTO> selectrandominfo() throws Exception{
		return mapper.selectrandominfo();
	}
	
	
	}


