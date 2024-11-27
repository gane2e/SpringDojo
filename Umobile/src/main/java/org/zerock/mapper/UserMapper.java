package org.zerock.mapper;

import java.util.Map;

import org.zerock.domain.UserVO;

public interface UserMapper {
	
	public void insertUser(UserVO vo); //회원가입 처리

	public UserVO read(Map<String, String> params); //로그인 처리
	
	public int checkEmail(String email); //이메일 중복체크
	
	public boolean updateUser(UserVO vo); //회원정보 수정
	
	public boolean deleteUser(long uno); //회원 탈퇴
	
}
