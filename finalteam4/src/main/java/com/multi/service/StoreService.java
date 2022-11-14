package com.multi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.dto.MenuDTO;
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
	
	public List<StoreDTO> searchstore(String txt) throws Exception {
		return mapper.searchstore(txt);
	}
	
	public List<StoreDTO> detail(Integer storeid) throws Exception {
		return mapper.detail(storeid);
	}

	public List<StoreDTO> catedetail(Integer cateid) throws Exception{
		return mapper.catedetail(cateid);
	}

	public List<StoreDTO> detailimg(Integer cateid) throws Exception{
		return mapper.detailimg(cateid);
	}

	
	
	
}
