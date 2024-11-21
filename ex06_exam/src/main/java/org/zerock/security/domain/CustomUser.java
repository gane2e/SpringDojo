package org.zerock.security.domain;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.zerock.domain.MemberVO;

import lombok.Getter;

@Getter
public class CustomUser extends User{

	private MemberVO member;
	
	/* 유저네임, 패스워드, 권한리스트 넘겨줌 */
	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}
	
	
	/* 
	 * new SimpleGrantedAuthority 란 무엇인가 ,,, GrantedAuthority[인터페이스]
	 * User 생성자 중 Collection<? extends GrantedAuthority> 이자리에는 [GrantedAuthority]를 상속받은 타입만 정의될 수 있음,,
	 * SimpleGrantedAuthority는 [GrantedAuthority]를 상속받았기 때문에 해당 타입으로 정의함
	 * */
	
	public CustomUser(MemberVO vo) {
		super(vo.getUserid(), vo.getUserpw() ,vo.getAuthList().stream().map(auth -> new SimpleGrantedAuthority(auth.getAuth()))
				.collect(Collectors.toList()));
		
		this.member = vo;
	}

}
