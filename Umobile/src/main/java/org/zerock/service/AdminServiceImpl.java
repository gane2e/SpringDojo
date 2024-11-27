package org.zerock.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.AdminVO;
import org.zerock.mapper.AdminMapper;
import org.zerock.mapper.UserMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService{

	@Autowired
	private final AdminMapper mapper;
	
	@Override
	public AdminVO login(String username, String password) {
		
	    
	    AdminVO adminVO = mapper.read(username);
		
	    
	    // 관리자 계정이 존재하고, 입력된 비밀번호가 DB 비밀번호와 일치하는지 확인
        if(adminVO != null && adminVO.getPassword().equals(password)) {
        	return adminVO;
        }
        
		return null; //로그인 실패
	}

}
