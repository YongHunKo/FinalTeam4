package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.dto.StoreimgDTO;
import com.multi.frame.MyMapper;
@Repository
@Mapper
public interface StoreimgMapper extends MyMapper<Integer, StoreimgDTO>{
	public List<StoreimgDTO> selectstoreid(Integer storeid);

}
