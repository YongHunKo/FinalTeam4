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
public class PayDTO {

	private Integer payid;
	private Integer orderlistno;
	private String custid;
	private Integer price;
	private String paystatus;
	
}
