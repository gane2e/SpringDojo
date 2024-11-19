package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
//@AllArgsConstructor
@RequiredArgsConstructor //--> 생성자대체
public class BoardServiceImpl implements BoardService {

	private final BoardMapper mapper;
	private List<BoardVO> list;
	
	@Override
	public void register(BoardVO vo) {
		log.info("register......." + vo);
		mapper.insertSelectKey(vo);
	}

	@Override
	public BoardVO get(Long bno) {
		log.info("get..........");
		return mapper.read(bno);
	}

	@Override //성공시 1 실패시 0 리턴
	public boolean modify(BoardVO vo) {
		log.info("modify....");
		return mapper.update(vo) == 1;
	}

	@Override //성공시 1 실패시 0 리턴
	public boolean remove(Long bno) {
		log.info("remove....");
		return mapper.delete(bno) == 1;
	}

	/*
	 * @Override public List<BoardVO> getList() { log.info("List........."); //
	 * List<BoardVO> list = mapper.getList(); // return list;
	 * 
	 * return mapper.getList(); }
	 */

	@Override
	public List<BoardVO> getList(Criteria cri) {
		log.info("getList.........");
		
		return mapper.getListWithPaging(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		return mapper.getTotalCount(cri);
	}

}
