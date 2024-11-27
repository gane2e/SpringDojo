package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.OrderVO;

public interface OrderMapper {

	// 주문내역 저장
	public void orderInsert(OrderVO orderVO);

	// 한 사람의 주문내역 조회 (유저 마이페이지)
	public List<OrderVO> orderRead(long uno);

	// 모든 주문내역 조회 (관리자 페이지)
	public List<OrderVO> orderList();

}
