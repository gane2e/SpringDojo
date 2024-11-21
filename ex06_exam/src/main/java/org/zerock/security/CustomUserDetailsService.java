package org.zerock.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.zerock.domain.MemberVO;
import org.zerock.mapper.MemberMapper;
import org.zerock.security.domain.CustomUser;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private MemberMapper memberMapper;

	/*
	 * 사용자가 로그인할 때 입력한 사용자 이름을 통해 
	 * 해당 사용자의 정보를 데이터베이스나 다른 저장소에서 가져와
	 * 인증을 처리하는 데 사용
	 */
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		/* DB접근과정,,, username받아 sql처리해서 vo로 받아옴*/
		MemberVO vo = memberMapper.read(username);
		
		/* 
		 * vo --> 
		 * MemberVO(userid=admin90, 
		 * userpw=$2a$10$0h/N0Cqp9VN5ISwNIH.y7edsvMVIOZp.mHwV8NtvTc98YlNgu48MO, 
		 * userName=관리자90, enabled=1, regDate=Wed Nov 20 17:53:37 KST 2024, updataDate=null, 
		 * authList=[AuthVO(userid=admin90, auth=ROLE_ADMIN)])
		 */
		
		
		/* vo 넘겨서 DB에서 받아온 사용자 정보 객체 생성해옴 */
		log.warn("vo -------------->" + vo);
		
	
		
		return new CustomUser(vo);
	}


}
