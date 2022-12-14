package com.multi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.dto.MenuimgDTO;
import com.multi.frame.MyService;
import com.multi.mapper.MenuimgMapper;

@Service
public class MenuimgService implements MyService<Integer, MenuimgDTO> {
	
	@Autowired
	MenuimgMapper mapper;

	@Override
	public void register(MenuimgDTO v) throws Exception {
		mapper.insert(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);
	}

	@Override
	public void modify(MenuimgDTO v) throws Exception {
		mapper.update(v);
	}

	@Override
	public MenuimgDTO get(Integer k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<MenuimgDTO> getall() throws Exception {
		return mapper.selectall();
	}
	
	public List<MenuimgDTO> selectstore(Integer storeid) throws Exception{
		return mapper.selectstore(storeid);
	}
}
