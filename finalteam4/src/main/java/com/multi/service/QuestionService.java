package com.multi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.dto.QuestionDTO;
import com.multi.frame.MyService;
import com.multi.mapper.QuestionMapper;

@Service
public class QuestionService implements MyService<Integer, QuestionDTO>{

	@Autowired
	QuestionMapper mapper;
	
	@Override
	public void register(QuestionDTO v) throws Exception {
		mapper.insert(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);
	}

	@Override
	public void modify(QuestionDTO v) throws Exception {
		mapper.update(v);
	}

	@Override
	public QuestionDTO get(Integer k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<QuestionDTO> getall() throws Exception {
		return mapper.selectall();
	}

}
