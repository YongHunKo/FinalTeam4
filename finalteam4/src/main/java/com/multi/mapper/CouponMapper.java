package com.multi.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.dto.CouponDTO;
import com.multi.frame.MyMapper;

@Repository
@Mapper
public interface CouponMapper extends MyMapper<Integer, CouponDTO>{

}
