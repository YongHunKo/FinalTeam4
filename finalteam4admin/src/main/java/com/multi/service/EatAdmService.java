package com.multi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.dto.EatAdmDTO;
import com.multi.frame.MyService;
import com.multi.mapper.EatAdmMapper;

@Service
public class EatAdmService implements MyService<String, EatAdmDTO> {
	@Autowired
	EatAdmMapper mapper;

	@Override
	public void register(EatAdmDTO v) throws Exception {
		mapper.insert(v);
	}

	@Override
	public void remove(String k) throws Exception {
		mapper.delete(k);
	}

	@Override
	public void modify(EatAdmDTO v) throws Exception {
		mapper.update(v);
	}

	@Override
	public EatAdmDTO get(String k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<EatAdmDTO> getall() throws Exception {
		return mapper.selectall();
	}
	
	
}
