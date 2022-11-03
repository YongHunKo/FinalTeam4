package com.multi.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.dto.WishlistDTO;
import com.multi.frame.MyMapper;

@Mapper
@Repository
public interface WishlistMapper extends MyMapper<Integer,WishlistDTO> {

}
