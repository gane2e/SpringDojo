package org.zerock.controller;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.AdminVO;
import org.zerock.domain.NoticeVO;
import org.zerock.domain.ProductVO;
import org.zerock.service.AdminService;
import org.zerock.service.NoticeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/admin/*")
@RequiredArgsConstructor
public class AdminController {

	@Autowired
	private final AdminService service;

	@Autowired
	private final NoticeService noticeService;

	@GetMapping("/adminloginJoin")
	public String showAdminLoginPage() {

		log.info("addlogin Page.......");

		return "admin/adminloginJoin";

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

		return "redirect:/admin/Adminmain";
	}

	@GetMapping("/logout")
	public String adminLogout(HttpSession session) {

		log.info("--- 로그아웃 요청받음 ---");
		log.info("로그인 요청자 세션 ---> " + session);

		session.invalidate(); // 세션 무효화

		log.info("세션 무효화 완료 -> 로그인 페이지 리다이렉트");

		return "redirect:/admin/adminloginJoin";
	}

	@GetMapping("/Adminmain") // 공지사항 리스트 (3개) 불러오기
	public String adminMain(Model model) {
		List<NoticeVO> noticeList = noticeService.getRecentNotices(3);
		model.addAttribute("noticeList", noticeList);
		return "admin/Adminmain"; // JSP 파일 이름
	}

	@GetMapping("/read/{nno}") // 공지사항 상세보기
	public String read(@PathVariable Long nno, Model model) {
		NoticeVO notice = noticeService.read(nno);
		model.addAttribute("notice", notice);
		return "admin/read";
	}

	@GetMapping("/modify/{nno}") // 공지 수정
	public String updateForm(@PathVariable Long nno, Model model) {
		NoticeVO notice = noticeService.read(nno);

		// LocalDateTime -> String 변환
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedDate = notice.getRegdate().format(formatter);

		model.addAttribute("notice", notice);
		model.addAttribute("formattedDate", formattedDate);

		return "admin/modify";
	}

	@PostMapping("/modify/{nno}") // 공지 수정 처리
	public String update(NoticeVO notice) {
		noticeService.update(notice);
		return "redirect:/admin/Adminmain";
	}

	@DeleteMapping("/delete/{nno}") // 공지 삭제
	public ResponseEntity<Void> deleteNotice(@PathVariable Long nno) {
		try {
			noticeService.delete(nno);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}