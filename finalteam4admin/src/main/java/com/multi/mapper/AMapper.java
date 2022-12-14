package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.dto.ChartDTO;

@Repository
@Mapper
public interface AMapper {
	public List<ChartDTO> chart1();
	public int getCustCnt();
	public int getStoreCnt();
	public int getReserveCnt();
	public int getSalesCnt();
}
