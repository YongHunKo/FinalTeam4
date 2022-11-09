package com.multi.dto;

import java.util.Date;

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
public class ReserveDTO {

	private Integer reserveno;
	private Integer orderlistno;
	private Integer menuid;
	private Integer cnt;
	private Integer price;
	
	private Date orderdate;
	private String menuname;
	private String menuimg;
	private String storename;
	private String reservedate;
	private String reservetime;
	private String orderprice;
}
