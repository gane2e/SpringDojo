package org.zerock.service;

import org.zerock.domain.AdminVO;

public interface AdminService {
	
	public AdminVO login(String username, String password);

}
