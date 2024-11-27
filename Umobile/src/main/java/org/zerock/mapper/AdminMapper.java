package org.zerock.mapper;

import org.zerock.domain.AdminVO;
import org.zerock.domain.ProductVO;

public interface AdminMapper {
	
	public AdminVO read(String username); // 관리자 로그인 처리

	public void insertPhone(ProductVO productVO); //관리자 상품등록
}
