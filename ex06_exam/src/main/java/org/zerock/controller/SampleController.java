package org.zerock.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/sample/*") 
@Controller
public class SampleController {
	
	@GetMapping("/all") //모든 사용자가 접근 가능한 URI
	public void doAll() {
		log.info("do all can access everybody");
	}
	
	@GetMapping("/member") //로그인 한 사용자만 접근 가능한 URI(로그인 인증 필요)
	public void doMember() {
		log.info("logined member");
	}
	
	@GetMapping("/admin") //로그인 한 사용자 중 관리자만 접근 가능한 URI(로그인 인증+관리자 인증 필요)
	public void doAdmin() {
		log.info("admin only");
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MEMBER')")
	@GetMapping("/annoMember")
	public void doMember2() {
		log.info("logined annotation member");
	}
	
	@Secured({"ROLE_ADMIN"})
	@GetMapping("/annoAdmin")
	public void doAdmin2() {
		log.info("admin annotation only");
	}
	
	
}
