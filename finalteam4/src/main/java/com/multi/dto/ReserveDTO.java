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
public class ReserveDTO {

	private Integer reserveno;
	private Integer orderlistno;
	private Integer menuid;
	private Integer cnt;
	private Integer price;
	
	private String storename;
	private String menuname;
	private Integer reservedate;
	private Integer reservetime;
	
	private String custid;
}
