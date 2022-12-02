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
public class CartDTO {
	private Integer cartid;
	private String custid;
	private Integer menuid;
	private Integer cnt;
	
	//조인
	private String menuname;
	private Integer price;
	private String menuimg;
	private Integer totalprice;
	private String adminid;
	private Integer storeid;
	
	

}
