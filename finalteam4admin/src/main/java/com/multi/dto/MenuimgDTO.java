package com.multi.dto;

import org.springframework.web.multipart.MultipartFile;

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
public class MenuimgDTO {
	private Integer menuimgno;
	private Integer menuid;
	private String menuimg;
	
	private MultipartFile mimg;
	
	//조인
		private String storename;
		private String menuname;
}
