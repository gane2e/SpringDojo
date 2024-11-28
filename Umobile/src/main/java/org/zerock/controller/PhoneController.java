package org.zerock.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.zerock.domain.OrderVO;
import org.zerock.domain.ProductVO;
import org.zerock.service.OrderService;
import org.zerock.service.ProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/phone/*")
@RequiredArgsConstructor
public class PhoneController {

	private final ProductService service;
	private final OrderService orderService;
	
	  @GetMapping("/phoneList") 
	    public void phoneProductPage(Model model) {
		  
			List<ProductVO> products = service.getProduct();
			model.addAttribute("products", products);
			
			log.info("프로덕트 model -> " + model);
	    }
	  
	    
	    @GetMapping("/PhoneDetail") 
	    public void phoneProductDetail(@RequestParam("cno") Long cno, Model model) {
	        
	    	ProductVO product = service.read(cno);
	    	
	    	model.addAttribute("product", product);
	    	log.info("상품 model 상세정보 ---->" + model);
	    }
	    
	    @PostMapping("/phone/add")
	    public String phoneAdd(
	    		@RequestParam("uno") long uno,
	    		@RequestParam("cno") long cno,
	    		@RequestParam("phonecolor") String color,
	    		@RequestParam("installment") String installment ,
	    		@RequestParam("vatPrice") double vatPrice,
	    		Model model){

	    	log.info("회원고유키 ---> " + uno);
	    	log.info("할부 ---> " + installment);
	    	log.info("색상 ---> " + color);
	    	
	    	OrderVO orderVO = new OrderVO();
	    	
	    	orderVO.setUno(uno);
	    	orderVO.setCno(cno);
	    	orderVO.setColor(color);
	    	orderVO.setInstallment(installment);
	    	orderVO.setVatPrice(vatPrice);
	    	
	    	log.info("orderVO ---> " + orderVO);
	    	
	    	model.addAttribute("msg", "success");

	    	orderService.addPhone(orderVO);
	    	
	    	return "redirect:/phone/phoneList";
	    }
	    
	    
	    @GetMapping("/user/login") 
	    public String userLogin() {
			
	    	log.info("비회원은 가입신청하면 로그인페이지로 보냅니다...");
	    	
	    	return "user/login";
	    }
	
}
