package org.zerock.service;

import org.zerock.domain.UserVO;

public interface UserService {
	
	public void register(UserVO vo);
	
	public UserVO login(String username, String password);
	
	public boolean checkEmail(String username);

}
