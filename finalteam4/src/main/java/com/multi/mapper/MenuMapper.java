package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.dto.MenuDTO;
import com.multi.frame.MyMapper;

@Repository
@Mapper
public interface MenuMapper extends MyMapper<Integer, MenuDTO>{
	public List<MenuDTO> selectcatemenu(Integer menucateid);
}
