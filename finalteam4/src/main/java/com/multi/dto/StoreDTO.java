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
public class StoreDTO {
	private Integer storeid;
	private Integer cateid;
	private String storename;
	private String storeintroduce;
	private String storetel; 
	private String storestatus;
	private String storeinfo;

}
