package org.zerock.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.UserVO;
import org.zerock.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import oracle.jdbc.proxy.annotation.Post;

@Controller
@Log4j
@RequestMapping("/user/*")
@RequiredArgsConstructor
public class UserjoinController {

	private final UserService service;
	
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    
    @GetMapping("/join")
    public String userJoin(Model model) {
    	
        log.info("user Login page");
        return "user/join";  
    }
    
    
    // ID 중복체크
    @PostMapping("/user/checkEmail")
    public String checkEmail(@RequestParam("username") String username) {
        boolean isEmailExist = service.checkEmail(username);
        return isEmailExist ? "exists" : "not exists";
    }

    
    
    @PostMapping("/doJoin")
    public String userJoin(UserVO vo, BindingResult result, Model model){
    	
    	log.info("회원가입 진입---------------");
		
		String rawPw = ""; 
		String encodePw = "";
    	
    	// 비밀번호 확인이 일치하지 않으면 에러 처리
        if (!vo.getPassword().equals(vo.getPasswordConfirm())) {
            result.rejectValue("passwordConfirm", "error.passwordConfirm", "비밀번호 확인이 일치하지 않습니다.");
        }

        // 유효성 검사 실패 시 다시 회원가입 페이지로 리다이렉트
        if (result.hasErrors()) {
            return "user/join";  // 에러 발생 시 이동할 페이지
        }
        
		rawPw = vo.getPassword(); 
		encodePw = passwordEncoder.encode(rawPw);
		vo.setPassword(encodePw);
		

        service.register(vo);

		log.info("-------------회원가입 test완료------------");

        return "redirect:/user/login";  // 회원가입 성공 후 로그인 페이지로 리다이렉트
    }
    
    
    
    
	@GetMapping("/login")
	public String userLogin(String error , Model model) {
	    log.info("user Login page");
	    
		/*
		 * if(error != null) { model.addAttribute("error",
		 * "Login Error Check Your Account"); }
		 */
	    
	    return "user/login";  
	}
	
	@PostMapping("/login")
	public String userLogin(@RequestParam String username, @RequestParam String password, Model model, HttpSession session) {
		
		
		log.info("-------로그인 완료-----------");
		log.info(username);
		
		UserVO user = service.login(username, password);
		
		if(user == null) {
			model.addAttribute("error", "Invalid username or password");
            return "user/login";  // 로그인 페이지로 다시 돌아가기
		}
		
		// 뷰에 데이터를 전달용
        model.addAttribute("user", user);
        
        // 로그인 성공 시 세션에 사용자 정보 저장
        session.setAttribute("user", user);
        
        log.info("로그인한 유저정보 ------> " + user);
        log.info("Model정보 ------> " + model);
		
		return "redirect:/user/myfage";
	}
	
	
	
	@GetMapping("/myfage")
	public String myFage(Model model) {
	    log.info("user myFage");
	    
	    return "user/myfage";  
	}
	
	
}