package org.zerock.mapper;

import java.util.Map;

import org.zerock.domain.UserVO;

public interface UserMapper {
	
	public void insertUser(UserVO vo); //회원가입 처리

	public UserVO read(Map<String, String> params); //로그인 처리
	
	public int checkEmail(String username); //이메일 중복체크
	
}
