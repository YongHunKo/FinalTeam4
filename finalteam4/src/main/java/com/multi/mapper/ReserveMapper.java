package com.multi.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.dto.ReserveDTO;
import com.multi.frame.MyMapper;

@Mapper
@Repository
public interface ReserveMapper extends MyMapper<Integer,ReserveDTO> {

}
