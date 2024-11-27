package org.zerock.service;

import org.zerock.domain.UserVO;

public interface UserService {
	
	public void register(UserVO vo);
	
	public UserVO login(String username, String password);
	
	public boolean checkEmail(String email);
	
	public boolean updateUser(UserVO vo); //회원정보 수정
	
	public boolean deleteUserByEmail(long uno);

}
