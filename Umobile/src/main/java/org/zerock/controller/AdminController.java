package org.zerock.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.AdminVO;
import org.zerock.domain.ProductVO;
import org.zerock.service.AdminService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/admin/*")
@RequiredArgsConstructor
public class AdminController {

	@Autowired
	private final AdminService service;

	@GetMapping("/login")
	public String showAdminLoginPage() {

		log.info("addlogin Page.......");

		return "admin/login";

	}

	@PostMapping("/login")
	public String adminLogin(@RequestParam String username, @RequestParam String password, HttpSession session) {

		log.info("-------관리자 로그인 진입-----------");
		log.info(username);
		log.info(password);

		AdminVO admin = service.login(username, password);

		log.info(admin);

		// 로그인 성공 시 세션에 사용자 정보 저장
		session.setAttribute("admin", admin);

		log.info("로그인한 관리자 정보 ------> " + admin);

		return "redirect:/admin/dashBoard";
	}

	//
	@GetMapping("/dashBoard")
	public String dashBoard() {

		log.info("--- 관리자 페이지 진입 ---");

		return "admin/dashBoard";
	}

	@GetMapping("/logout")
	public String adminLogout(HttpSession session) {

		log.info("--- 로그아웃 요청받음 ---");
		log.info("로그인 요청자 세션 ---> " + session);

		session.invalidate(); // 세션 무효화

		log.info("세션 무효화 완료 -> 로그인 페이지 리다이렉트");

		return "redirect:/admin/login";
	}

	// 상품 등록페이지 진입
	@GetMapping("/addProduct")
	public void addProduct() {
		log.info("---- 상품 등록 페이지 진입 ----");
	}

	// 상품 등록 요청
	@PostMapping("/addProduct")
	public String addProduct(@RequestPart MultipartFile thumbnail, ProductVO productVO, RedirectAttributes redirectAttributes) throws IOException {

		log.info("---- 상품 등록 요청 받음 ----");
		log.info("요청받은 상품 ---> " + productVO);
		log.info("요청받은 이미지 ---> " + thumbnail.getOriginalFilename());

		// 1. 이미지 파일을 byte[]로 변환
		byte[] thumbnailBytes = thumbnail.getBytes();

		// 2. ProductVO에 이미지 데이터를 저장
		productVO.setThumbnail(thumbnailBytes);

		// 3. 상품 정보를 DB에 저장
		service.insertPhone(productVO);

		// 4. 등록 후 성공 메시지
		redirectAttributes.addFlashAttribute("message", "상품이 성공적으로 등록되었습니다.");

		return "redirect:/admin/dashBoard";
	}

}