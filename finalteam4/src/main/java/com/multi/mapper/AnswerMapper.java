package com.multi.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.dto.AnswerDTO;
import com.multi.frame.MyMapper;

@Repository
@Mapper
public interface AnswerMapper extends MyMapper<Integer, AnswerDTO> {

}
