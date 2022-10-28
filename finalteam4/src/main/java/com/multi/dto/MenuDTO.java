package com.multi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class MenuDTO {
	private Integer menuid;
	private Integer storeid;
	private Integer menucateid;
	private String menuname;
	private Integer menuprice;
	private String menuinfo;
	
	//조인
	private String menuimg;
}
