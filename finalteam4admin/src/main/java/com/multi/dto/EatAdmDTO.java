package com.multi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EatAdmDTO {
	private String adminid;
	private String pwd;
	private String adminname;
	private int alevel;
	
	//조인
	private int storeid;
}
