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
public class OrderlistDTO {
	private Integer orderlistno;
	private String custid;
	private Date orderdate;
	private Integer cnt;
	private Integer totalprice;
	private Date reservedate;
	private Date reservetime;

}
