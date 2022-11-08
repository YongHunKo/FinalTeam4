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
public class StoreimgDTO {
	private Integer storeimgno;
	private Integer storeid;
	private String storeimg;

	// maincenter random img 조인문
	
	private String storename;
	private String storeinfo;
	private String storeintroduce;
	private String storestatus;
	private  String menuimg;
	
}
