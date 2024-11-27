package org.zerock.domain;

import java.util.Date;

import lombok.Data;

@Data
public class OrderVO {

	private long vno; // 구매내역 식별키
	private long uno; // 회원 식별키
	private long cno; // 상품 식별키
	private String color; // 색상
	private String installment; // 할부
	private Date regDate; // 구매 일자
	private double vatPrice; // 결제 금액(부가세포함)
}
