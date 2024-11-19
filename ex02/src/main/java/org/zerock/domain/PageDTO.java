package org.zerock.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {

	
	private int startPage; //페이징 첫번호 (ex: 1)
	private int endPage; //페이징 마지막번호 (ex: 10)
	private boolean prev, next; //이전, 다음
	private boolean first; //처음으로, 마지막으로
	
	private int total; //총 게시물 개수
	private Criteria cri;
	
	public PageDTO(Criteria cri, int total) {
		
		this.cri = cri;
		this.total = total;
		
		this.endPage = (int)(Math.ceil(cri.getPageNum() / (double)cri.getAmount()) * cri.getAmount());
		startPage = this.endPage - 9;
		
		// 총 페이징 수 : 
		int realEnd = (int)(Math.ceil( (total*1.0)/cri.getAmount()));
		
		// 총 페이징 수 보다 ***현재 조회중인 페이징넘버의 end가 더 크다면***, end를 real로 덮어쓴다.
		if(realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		
		// 현재 조회중인 페이징넘버의 start가 1보다 크면 (이전)버튼
		this.prev = startPage > 1;
		// 현재 조회중인 페이징넘버의 end가 총 페이징 수 보다 작다면 (다음)버튼
		this.next = this.endPage < realEnd;
		
		 // 처음으로, 마지막 페이지 버튼 표시 여부
        this.first = startPage > 1;  // startPage가 1보다 크면 처음으로 버튼 활성화
		
	}
}
