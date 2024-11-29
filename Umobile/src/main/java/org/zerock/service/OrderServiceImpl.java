package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.OrderVO;
import org.zerock.mapper.AdminMapper;
import org.zerock.mapper.OrderMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

	@Autowired
	private final OrderMapper mapper;
	
	
	@Override //주문내역 저장
	public void addPhone(OrderVO orderVO) {
		mapper.orderInsert(orderVO);
	}


	@Override //개인 신청내역 조회
	public List<OrderVO> orderRead(long uno) {
		return mapper.orderRead(uno);
	}
	

}
