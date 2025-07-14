package org.spr.domain;

import java.util.Date;

import lombok.Data;

@Data // import lombok.Data;
public class BotestVO {
	// DTO 게터/ 세터
	
	private Long bno;
	private String title;
	private String content;
	private String writer;
	private Date regDate; // import java.util.Date;
	private Date updateDate;

}
