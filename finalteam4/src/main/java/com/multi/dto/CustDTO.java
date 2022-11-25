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
public class CustDTO {
	private String custid;
	private String custpwd;
	private String custname;
	private Date custrdate;
	private String birth;
	private String tel;
	private String lv;
	
	// 프로필이미지 테스트
	private String profileimg;

}
