package org.zerock.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyPageDTO;
import org.zerock.domain.ReplyVO;
import org.zerock.service.ReplyService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/replies/")
@Log4j
@RequiredArgsConstructor
public class ReplyController {

	private final ReplyService service;
	
	
	// http://localhost:8080/replies/new --> json 데이터를 replyvo객체로 convert(바꿈)후 DB저장
	// 저장 성공이면 ResponseEntity에 "success" 문자열과 상태코드 200을 응답해준다
	// 실패하면 ResponseEntity에 상태코드 500 응답
	@PostMapping(value = "/new", 
			consumes = MediaType.APPLICATION_JSON_VALUE, // 요청(json)받을 타입
			produces = MediaType.TEXT_PLAIN_VALUE //응답(String)할 타입
			) 
	public ResponseEntity<String> create(@RequestBody ReplyVO vo){
		log.info("create........" + vo);
		
		int insertCount = service.register(vo);
		
		return insertCount == 1 
				? new ResponseEntity<String>("SUCCESS!", HttpStatus.OK)
				: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	
	
	// 특정 게시물의 댓글 목록 확인
	// http://localhost:8080/replies/34번글/1페이지에 해당하는 댓글 10개 가져와라
	@GetMapping(value = "/pages/{bno}/{page}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ReplyPageDTO> getList(@PathVariable("bno") Long bno, @PathVariable("page") int page){
		
		log.info("getList....bno : " + bno + "page : " + page);
		Criteria cri = new Criteria(page, 10);
		
//		List<ReplyVO> list = service.getList(cri, bno);
		ReplyPageDTO list = service.getListPage(cri, bno);
		
		log.info("--------------");
		log.info(list);
		
		//reply.js파일에 ReplyPageDTO 타입의 객체를 보내주어야 함
		return new ResponseEntity<ReplyPageDTO>(list, HttpStatus.OK);
	}
	
	
	
	
	
	
	// 댓글 삭제/조회
	// http://localhost:8080/replies/34 -> 34번 삭제
	@DeleteMapping(value = "/{rno}", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> remove(@PathVariable("rno") Long rno){
		log.info("remove........" + rno);
		
		return service.remove(rno) == 1
				? new ResponseEntity<String>("SUCCESS!", HttpStatus.OK)
				: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	// http://localhost:8080/replies/39 --> 39번 레코드를 json으로 응답
	@GetMapping(value = "/{rno}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ReplyVO> get(@PathVariable("rno") Long rno){

		log.info("get........." + rno);
		ReplyVO replyVO = service.get(rno);
		return new ResponseEntity<ReplyVO>(replyVO, HttpStatus.OK);
	}
	

	// 댓글 수정
	// http://localhost:8080/replies/39 + json 데이터 / 39번 수정한다.
	@RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH}, //PUT or Path 로 요청받음
			value = "/{rno}", 
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.TEXT_PLAIN_VALUE}
	)
	public ResponseEntity<String> modify(
			@PathVariable("rno") Long rno,
			@RequestBody ReplyVO vo //JSON객체를 vo로변환
			){
		log.info("modify.....rno" + rno + "reply : " + vo);

		vo.setRno(rno);
		return service.modify(vo) == 1 //성공하면 1
				? new ResponseEntity<String>("SUCCESS!", HttpStatus.OK)
				: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	
}
