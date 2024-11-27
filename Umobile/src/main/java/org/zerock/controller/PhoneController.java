package org.zerock.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.ProductVO;
import org.zerock.service.ProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/phone/*")
@RequiredArgsConstructor
public class PhoneController {

	private final ProductService service;
	
	  @GetMapping("/phoneList") 
	    public String phoneProductPage(Model model) {
		  
			List<ProductVO> products = service.getProduct();
			model.addAttribute("products", products);
			
			log.info("프로덕트 model -> " + model);
			
	        return "phone/phoneList"; 
	    }
	  
	    
	    @GetMapping("/PhoneDetail") 
	    public String phoneProductDetail(@RequestParam("cno") Long cno, Model model) {
	        
	    	ProductVO productVO = service.read(cno);
	    	
	    	model.addAttribute("product", productVO);
	    	log.info("상품 상세페이지 이동완료...");
	        return "phone/PhoneDetail"; 
	    }
	
}
