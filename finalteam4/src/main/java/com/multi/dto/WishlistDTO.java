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
public class WishlistDTO {

	private Integer wishlistid;
	private Integer storeid;
	private String custid;
	private Date rdate;
	
	//조인
	private String storename;
	private String storeimg;
	private String storeintroduce;
}
