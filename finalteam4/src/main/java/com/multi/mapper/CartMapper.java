package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.dto.CartDTO;
import com.multi.dto.MenuDTO;
import com.multi.frame.MyMapper;
@Repository
@Mapper
public interface CartMapper extends MyMapper<Integer, CartDTO>{
	public List<CartDTO> selectcart(String custid);
	public Integer modifyCount(CartDTO cart);

}
