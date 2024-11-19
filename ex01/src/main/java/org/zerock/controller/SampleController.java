package org.zerock.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/sample/")
public class SampleController {

//	@RequestMapping("/sample/")
	@RequestMapping(value="", method = {RequestMethod.GET, RequestMethod.POST})
	public void basic() {
		
		log.info("basic........");
		
	}
	
	@GetMapping("basicOnlyGet")
	public void basicGet2() {
		log.info("basic get only get........");
	}
	
	
	@GetMapping("ex01")
	public String ex01(SampleDTO dto) {
		
		log.info("" + dto);
		log.info(dto.getName());
		log.info(dto.getAge());
		
		return "ex01";
	}
	
	@GetMapping("ex02")
	// Http 요청 파라미터의 이름으로 바인딩하여 그 값을 변수에 저장한다.
	// @RequestParam : 파라미터를 1:1매핑함, 여러개의 값을 요청해야할 경우 일일히 1:1매핑이 필요함
	public String ex02(@RequestParam("name") String name,
						@RequestParam("age") int age) {
		log.info(name);	
		log.info(age);
		return "ex02";
	}
	
	//배열처리
	@GetMapping("ex02List")
	public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
		
		log.info(ids);
		return "ex02List";
	}
	
	@GetMapping("ex02Array") 
	public String ex02Array(@RequestParam("ids") String[] ids) {
		
		log.info("ex02Array -> " + Arrays.toString(ids));
		return "ex02Array";
	}
	
	@GetMapping("ex02Bean")
	public String ex02Bean(SampleDTOList list) {
		log.info(list);
		return "ex02Bean";
	}
	

	/* 바인더 방법1
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
	}
	*/
	@GetMapping("ex03") 
	public String ex03(TodoDTO todo) {
		log.info("todo : " + todo);
		return "ex03";
	}
	
	// @ModelAttribute : 사용자가 요청시 전달하는 값을 오브젝트 형태로 매핑해주는 어노테이션
	// N개의 요청을 오브젝트로 매핑 가능
	@GetMapping("ex04")
	public String ex04(SampleDTO dto, @ModelAttribute("page")int page) {
		log.info("dto ---> " + dto);
		log.info("page ---> " + page);
		return "sample/ex04";
	}
	
	@GetMapping("ex05")
	public void ex05() {
		log.info("/ex05........");
	}
	
	
	// @ResponseBody --> 응답을 json 타입으로 보낸다.
	@GetMapping("ex06")
	public @ResponseBody SampleDTO ex06() {
		log.info("/ex06....");
		
		SampleDTO dto = new SampleDTO();
		dto.setName("홍길동");
		dto.setAge(20);
		
		return dto;
	}
	
	
	// @RequestBody --> J
//	SON 타입 객체를 요청받는다
	@PostMapping("ex06_1")
	public String ex06_1(@RequestBody SampleDTO dto) {
		
		log.info("/ex06.......");
		log.info("dto ---> " + dto);
		
		return "ex06_1";
		
	}
	
	// ResponseEntity --> HttpEntity(HTTP요청or응답) 클래스를 구현한 자식클래스 + 클라이언트 요청을 포함함
	@GetMapping("ex07")
	public ResponseEntity<String> ex07(){
		log.info("/ex07...............");
		
		String msg = "{\"name\": \"홍길동\"}";
		HttpHeaders header = new HttpHeaders();
		header.add("Content-type", "application/json;charset=UTF-8");
		
		return new ResponseEntity<String>(msg, header, HttpStatus.OK);
	}
	
	@GetMapping("/exUpload")
	public void exUpload() {
		log.info("exUpload.......");
	}
	
	@PostMapping("/exUploadPost") 
	public void exUploadPost(ArrayList<MultipartFile> files) {
		files.forEach(file->{
			log.info("----------------------");
			log.info("name : " + file.getOriginalFilename());
			log.info("size : " + file.getSize());
		});
	}
	
	
}
