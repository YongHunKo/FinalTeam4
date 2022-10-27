package com.multi.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.dto.QuestionDTO;
import com.multi.frame.MyMapper;

@Repository
@Mapper
public interface QuestionMapper extends MyMapper<Integer, QuestionDTO> {

}
