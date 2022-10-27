package com.multi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.dto.AnswerDTO;
import com.multi.frame.MyService;
import com.multi.mapper.AnswerMapper;

@Service
public class AnswerService implements MyService<Integer, AnswerDTO>{

	@Autowired
	AnswerMapper mapper;

	@Override
	public void register(AnswerDTO v) throws Exception {
		mapper.insert(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);
	}

	@Override
	public void modify(AnswerDTO v) throws Exception {
		mapper.update(v);
	}

	@Override
	public AnswerDTO get(Integer k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<AnswerDTO> getall() throws Exception {
		return mapper.selectall();
	}
	
	

}
