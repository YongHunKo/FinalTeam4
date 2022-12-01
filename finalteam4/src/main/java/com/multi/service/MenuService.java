package com.multi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.dto.MenuDTO;
import com.multi.frame.MyService;
import com.multi.mapper.MenuMapper;

@Service
public class MenuService implements MyService<Integer, MenuDTO> {
	
	@Autowired
	MenuMapper mapper;
	
	@Override
	public void register(MenuDTO v) throws Exception {
		mapper.insert(v);		
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);		
	}

	@Override
	public void modify(MenuDTO v) throws Exception {
		mapper.update(v);		
	}

	@Override
	public MenuDTO get(Integer k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<MenuDTO> getall() throws Exception {
		return mapper.selectall();
	}
	
	public List<MenuDTO> selectcatemenu(Integer menucateid) throws Exception {
		return mapper.selectcatemenu(menucateid);
	}
	
	public List<MenuDTO> searchmenu(String txt) throws Exception {
		return mapper.searchmenu(txt);
	}
	
	public List<MenuDTO> searchmenu2(String txt) throws Exception {
		return mapper.searchmenu2(txt);
	}
	
	public List<MenuDTO> searchmenu3(String txt) throws Exception {
		return mapper.searchmenu3(txt);
	}
	
	public List<MenuDTO> searchmenu4(String txt) throws Exception {
		return mapper.searchmenu4(txt);
	}
	
	public List<MenuDTO> searchmenuasc(String txt) throws Exception {
		return mapper.searchmenuasc(txt);
	}
	
	public List<MenuDTO> searchmenudesc(String txt) throws Exception {
		return mapper.searchmenudesc(txt);
	}

}
