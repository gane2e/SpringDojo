package org.zerock.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*") // /board/ 로 오는 모든 요청을 컨트롤러에서 처리함
@RequiredArgsConstructor //생성자 주입을 자동으로 설정
public class BoardController {
	
	private final BoardService service; // @RequiredArgsConstructor로 서비스 객체 생성
	private  BoardVO vo;

	
	// 리스트 호출
	@GetMapping("/list")
	public void list( @ModelAttribute("cri") Criteria cri, Model model) {
		log.info("list.............." + cri);
		List<BoardVO> list =  service.getList(cri);
		
		model.addAttribute("list" ,list);
		
		int total = service.getTotal(cri);
		model.addAttribute("pageMaker", new PageDTO(cri, total));
	}
	
	
	
	@GetMapping("/register")
	public void register() {
		
	}
	
	
	
//	@RequestMapping(value = "/register", method = { RequestMethod.POST })
	@PostMapping("/register") 
	public String register(BoardVO vo, RedirectAttributes rttr) {
		
		log.info("register");
		service.register(vo);
		rttr.addFlashAttribute("result", vo.getBno());
		return "redirect:/board/list";
	}
	
	// get or modify 요청 받음  (조회페이지/수정페이지)
	@GetMapping({"/get", "/modify"})
	public void get(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, Model model) {
		
		log.info("get....or.......modify...." + bno);
		BoardVO vo = service.get(bno);
		model.addAttribute("board", vo);
	}
	
	
	//게시물 삭제처리
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno,  @ModelAttribute("cri") Criteria cri ,RedirectAttributes rttr) {
		
		log.info("remove.......");
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		
		return "redirect:/board/list";
	} 
	
	// 게시물 수정처리
	@PostMapping("/modify") // RedirectAttributes -->화면이동이 필요할 때
	public String modify(BoardVO vo, @ModelAttribute("cri") Criteria cri , RedirectAttributes rttr) {
		
		log.info("modify -->" + vo);
		if(service.modify(vo)) {
			rttr.addFlashAttribute("result", "success");
		}
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/board/list";
	}
}

