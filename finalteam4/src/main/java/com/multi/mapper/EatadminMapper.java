package com.multi.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.dto.EatadminDTO;
import com.multi.frame.MyMapper;

@Repository
@Mapper
public interface EatadminMapper extends MyMapper<String, EatadminDTO>{

}
