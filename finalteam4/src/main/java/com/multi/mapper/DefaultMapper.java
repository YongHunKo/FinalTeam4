package com.multi.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.dto.DefaultDTO;
import com.multi.frame.MyMapper;

@Repository
@Mapper
public interface DefaultMapper extends MyMapper<String, DefaultDTO>{

}
