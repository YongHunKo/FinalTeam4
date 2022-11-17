package com.multi.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.dto.MenuimgDTO;
import com.multi.frame.MyMapper;

@Repository
@Mapper
public interface MenuimgMapper extends MyMapper<Integer, MenuimgDTO>{

}
