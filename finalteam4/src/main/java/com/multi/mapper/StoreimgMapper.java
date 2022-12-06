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
	public List<StoreimgDTO> selectrandom();
	public List<StoreimgDTO> selectrandominfo();
	public List<StoreimgDTO> today();
	public List<StoreimgDTO> today2();
	public List<StoreimgDTO> today3();
	public StoreimgDTO shareimg(Integer storeid);

}
