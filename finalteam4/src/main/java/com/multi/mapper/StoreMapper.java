package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.dto.StoreDTO;
import com.multi.frame.MyMapper;
@Repository
@Mapper
public interface StoreMapper extends MyMapper<Integer, StoreDTO>{
	public List<StoreDTO> searchstore(String txt);
	public List<StoreDTO> detail(Integer storeid);
	public List<StoreDTO> catedetail(Integer cateid);
	public List<StoreDTO> detailimg(Integer cateid);

}
