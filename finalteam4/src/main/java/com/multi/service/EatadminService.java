package com.multi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.dto.EatadminDTO;
import com.multi.frame.MyService;
import com.multi.mapper.EatadminMapper;

@Service
public class EatadminService implements MyService<String, EatadminDTO>{

	@Autowired
	EatadminMapper mapper;

	@Override
	public void register(EatadminDTO v) throws Exception {
		mapper.insert(v);
	}

	@Override
	public void remove(String k) throws Exception {
		mapper.delete(k);
	}

	@Override
	public void modify(EatadminDTO v) throws Exception {
		mapper.update(v);
	}

	@Override
	public EatadminDTO get(String k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<EatadminDTO> getall() throws Exception {
		return mapper.selectall();
	}

}
