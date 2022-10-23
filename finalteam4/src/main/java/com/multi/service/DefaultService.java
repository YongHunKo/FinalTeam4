package com.multi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.dto.DefaultDTO;
import com.multi.frame.MyService;
import com.multi.mapper.DefaultMapper;
@Service
public class DefaultService implements MyService<String, DefaultDTO>{
	
	@Autowired
	DefaultMapper mapper;
	
	@Override
	public void register(DefaultDTO v) throws Exception {
		mapper.insert(v);		
	}

	@Override
	public void remove(String k) throws Exception {
		mapper.delete(k);		
	}

	@Override
	public void modify(DefaultDTO v) throws Exception {
		mapper.update(v);		
	}

	@Override
	public DefaultDTO get(String k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<DefaultDTO> getall() throws Exception {
		return mapper.selectall();
	}

}
