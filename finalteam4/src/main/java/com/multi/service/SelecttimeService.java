package com.multi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.dto.SelecttimeDTO;
import com.multi.frame.MyService;
import com.multi.mapper.SelecttimeMapper;

@Service
public class SelecttimeService implements MyService<Integer, SelecttimeDTO> {

	@Autowired
	SelecttimeMapper mapper;
	@Override
	public void register(SelecttimeDTO v) throws Exception {
		mapper.insert(v);		
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);		
	}

	@Override
	public void modify(SelecttimeDTO v) throws Exception {
		mapper.update(v);		
	}

	@Override
	public SelecttimeDTO get(Integer k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<SelecttimeDTO> getall() throws Exception {
		return mapper.selectall();
	}

}
