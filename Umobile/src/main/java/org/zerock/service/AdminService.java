package org.zerock.service;

import org.zerock.domain.AdminVO;
import org.zerock.domain.ProductVO;

public interface AdminService {
	
	public AdminVO login(String username, String password);
	
	public void insertPhone(ProductVO productVO);

}
