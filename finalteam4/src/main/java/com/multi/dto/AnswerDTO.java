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
public class AnswerDTO {
	private Integer apostid;
	private Integer adminid;
	private String qpostid;
	private String title;
	private String qtext;
	private Date rdate;
}
