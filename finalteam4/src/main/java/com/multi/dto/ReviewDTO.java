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
public class ReviewDTO {
	private Integer reviewid;
	private String custid;
	private Integer storeid;
	private String revtext;
	private Integer star;
	
	private String storename;
}