package com.multi.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.dto.StoreDTO;
import com.multi.frame.MyMapper;
@Repository
@Mapper
public interface StoreMapper extends MyMapper<Integer, StoreDTO>{

}
