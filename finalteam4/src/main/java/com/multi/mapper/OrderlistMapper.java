package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.dto.OrderlistDTO;
import com.multi.frame.MyMapper;
@Repository
@Mapper
public interface OrderlistMapper extends MyMapper<Integer, OrderlistDTO>{
	public OrderlistDTO myorder_1(String custid) throws Exception;
	public List<OrderlistDTO> myorder(String custid) throws Exception;
	public OrderlistDTO ranking() throws Exception;
	public OrderlistDTO ranking2() throws Exception;
	public OrderlistDTO ranking3() throws Exception;
	public OrderlistDTO ranking4() throws Exception;
	public OrderlistDTO ranking5() throws Exception;
	public OrderlistDTO total_pay(String custid) throws Exception;
}
