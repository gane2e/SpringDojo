package org.zerock.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
//검색조건 처리를 위한 클래스
public class Criteria {

	private int pageNum; // 페이지 번호
	private int amount; // 화면당 레코드 개수
	
	private String type; // 제목 or 내용 or 저자 (검색타입)
	private String keyword; // 검색어
	
	public Criteria() {
		this(1,10);
	}
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	//타입에 검색조건을 분리 type --> TCW >> T|C|W (split으로 배열에 구분)
	//쿼리문에 foreach collection="typeArr" 로 작성함
	public String[] getTypeArr() {
		return type == null ? new String[] {} : type.split("");
	}
	
	/*
	 * T : 제목
	 * C : 내용
	 * W : 저자
	 * 
	 * TCW : (제목/내용/저자), TW : (제목/저자)
	 * 
	 */
	
}
