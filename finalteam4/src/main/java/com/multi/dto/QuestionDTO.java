package com.multi.dto;

import java.util.Date;

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
public class QuestionDTO {
	private Integer qpostid;
	private Integer storeid;
	private String custid;
	private String title;
	private String qtext;
	private Date rdate;
}
