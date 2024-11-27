package org.zerock.domain;

import java.util.Date;

import lombok.Data;

@Data
public class AdminVO {
	
	private long ano;
	private String username;
	private String password;
	/* private String passwordConfirm; */
	private String name;
	private String role;
	private Date regdate;

}
