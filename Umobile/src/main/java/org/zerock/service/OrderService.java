package org.zerock.service;

import java.util.List;

import org.zerock.domain.OrderVO;

public interface OrderService {

	// 주문내역 저장
	public void addPhone(OrderVO orderVO);

	// 한 사람의 주문내역 조회 (유저 마이페이지)
	public List<OrderVO> orderRead(long uno);

}
