package com.multi.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.dto.SelecttimeDTO;
import com.multi.frame.MyMapper;

@Repository
@Mapper
public interface SelecttimeMapper extends MyMapper<Integer, SelecttimeDTO> {

}
