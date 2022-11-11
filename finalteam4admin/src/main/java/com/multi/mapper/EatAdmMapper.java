package com.multi.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.dto.EatAdmDTO;
import com.multi.frame.MyMapper;

@Repository
@Mapper
public interface EatAdmMapper extends MyMapper<String,EatAdmDTO>{

}
