package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.dto.MenuDTO;
import com.multi.dto.ReserveDTO;
import com.multi.frame.MyMapper;

@Mapper
@Repository
public interface ReserveMapper extends MyMapper<Integer,ReserveDTO> {
	public List<ReserveDTO> myreserve(String custid) throws Exception;
}
