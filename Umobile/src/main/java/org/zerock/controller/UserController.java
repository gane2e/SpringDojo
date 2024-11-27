package org.zerock.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.UserVO;
import org.zerock.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import oracle.jdbc.proxy.annotation.Post;

@Controller
@Log4j
@RequestMapping("/user/*")
@RequiredArgsConstructor
public class UserController {

	private final UserService service;
	
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    
    // 회원가입 진입
    @GetMapping("/join")
    public String userJoin(Model model) {
    	
        log.info("user Login page");
        return "user/join";  
    }
    
    
    // ID 중복체크
    @PostMapping("/user/checkEmail")
    @ResponseBody //view에 요청응답하려면 필수로넣읍시다..
    public String checkEmail(@RequestParam("email") String email) {
        
    	log.info("email ----> " + email);
    	
    	boolean isEmailExist = service.checkEmail(email);
    	
        return isEmailExist ? "exists" : "not exists";
    }

    
    // 회원가입 요청처리
    @PostMapping("/doJoin")
    public String userJoin(UserVO vo, BindingResult result, Model model){
    	
    	log.info("회원가입 진입---------------");
		
		String rawPw = ""; 
		String encodePw = "";
		
		log.info("vo email 받았나 테스트 ---> " + vo.getEmail());
    	
    	// 비밀번호 확인이 일치하지 않으면 에러 처리
        if (!vo.getPassword().equals(vo.getPasswordConfirm())) {
            result.rejectValue("passwordConfirm", "error.passwordConfirm", "비밀번호 확인이 일치하지 않습니다.");
        }
        
        log.info("패스워드 체크 완료-------");

        // 유효성 검사 실패 시 다시 회원가입 페이지로 리다이렉트
        if (result.hasErrors()) {
            return "user/join";  // 에러 발생 시 이동할 페이지
        }
        
		rawPw = vo.getPassword(); 
		encodePw = passwordEncoder.encode(rawPw);
		vo.setPassword(encodePw);
		
		log.info("vo -------> " + vo);
		

        service.register(vo);

		log.info("-------------회원가입 test완료------------");

        return "redirect:/user/login";  // 회원가입 성공 후 로그인 페이지로 리다이렉트
    }
    
    
    //로그인요청
	@GetMapping("/login")
	public String userLogin(String error , Model model) {
	    log.info("user Login page");
	    
		/*
		 * if(error != null) { model.addAttribute("error",
		 * "Login Error Check Your Account"); }
		 */
	    
	    return "user/login";  
	}
	
	
	
	//로그인처리
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
		
		return "redirect:/";
	}
	
	
	
	//마이페이지 진입
	@GetMapping("/myfage")
	public String myFage(Model model) {
	    log.info("user myFage");
	    
	    return "user/myfage";
	}
	
	
	
	
	//회원수정 post처리
	@PostMapping("/update")
	public String updateUser(UserVO vo, BindingResult result
			, HttpServletRequest request){
	    	
		//test로그
		log.info("회원정보 수정 진입---------------");
			
		String rawPw = ""; 
		String encodePw = "";
		
		//test로그
		log.info("vo 정보 받았나 테스트 ---> " + vo.getEmail());
		
		UserVO session = (UserVO) request.getSession().getAttribute("user");
		
		//test로그
		log.info("회원 수정할 유저의 기존 session정보 읽기 ----> " + session);
    	
		vo.setUno(session.getUno());
		
    	// 비밀번호 확인이 일치하지 않으면 에러 처리
        if (!vo.getPassword().equals(vo.getPasswordConfirm())) {
            result.rejectValue("passwordConfirm", "error.passwordConfirm", "비밀번호 확인이 일치하지 않습니다.");
        }
        
        //test로그
        log.info("패스워드 체크 완료-------");
        
        // 유효성 검사 실패 시 다시 회원가입 페이지로 리다이렉트
        if (result.hasErrors()) {
            return "user/myfage";  // 에러 발생 시 이동할 페이지
        }
	        
		rawPw = vo.getPassword(); 
		encodePw = passwordEncoder.encode(rawPw);
		vo.setPassword(encodePw);
			
		//test로그
		log.info("회원정보 수정한 vo -------> " + vo);

	    service.updateUser(vo);

	    //test로그
		log.info("-------------회원수정 test완료------------");

		return "redirect:/user/myfage";  // 회원가입 성공 후 로그인 페이지로 리다이렉트
	    }
	
	
	
	
	//회원탈퇴 post처리
	@PostMapping("/delete")
	public String deleteUser(HttpServletRequest request) {
	    
		// 세션에서 UserVO 객체를 가져오기
		UserVO user = (UserVO) request.getSession().getAttribute("user");

		    Long uno = user.getUno();
		    log.info("세션에서 가져온 uno 값: " + uno);
	    
	    if (uno != null) {
	        boolean isDeleted = service.deleteUserByEmail(uno);
	        
	        if (isDeleted) {
	            // 세션을 무효화하고 로그인 페이지로 리다이렉트
	            request.getSession().invalidate();
	            return "redirect:/user/login"; // 로그인 페이지로 리다이렉트
	        } else {
	            return "error"; // 탈퇴 실패 시 오류 페이지로 이동
	        }
	    }
	    
	    return "redirect:/user/login"; // 로그인 세션이 없으면 로그인 페이지로 리다이렉트
	}
	
	
	
	
	
	
}