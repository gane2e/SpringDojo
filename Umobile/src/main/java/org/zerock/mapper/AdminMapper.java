package org.zerock.mapper;

import org.zerock.domain.AdminVO;

public interface AdminMapper {
	
	public AdminVO read(String username); // 관리자 로그인 처리

}
