package org.zerock.mapper;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	@Autowired
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
		mapper.getList().forEach(list-> log.info(list));
	}
	
	@Test
	public void testInsert() {
//		BoardVO board = new BoardVO();
//		board.setTitle("새로 작성하는 글2");
//		board.setContent("새로 작성하는 내용2");
//		board.setWriter("newbie2");
//		
//		mapper.insertSelectKey(board);
//		log.info(board);
	}
	
	@Test
	public void testRead() {
		Long bno = 2L;
		BoardVO boardVO =  mapper.read(bno);
		log.info(boardVO);
	}
	
	@Test
	public void testDelete() {
		int result = mapper.delete(22L);
		log.info(result);
	}
	
	@Test
	public void testUpdate() {

		Long bno = 5L;
		BoardVO vo = mapper.read(bno);
		
		vo.setTitle("수정 제목");
		vo.setContent("수정 내용");
		vo.setWriter("수정자");
		
		int result = mapper.update(vo);
		log.info(result);
	}
	
	@Test
	public void testPaging() {
		Criteria cri = new Criteria(5,10);
		mapper.getListWithPaging(cri)
		.forEach(list -> log.info(list));
	}
	
	@Test
	public void testSearch() {
		Map<String, String> map = new HashMap<String, String>();
		
		// T : 제목 /  C : 내용 / W : 저자
		
		map.put("T", "검색테스트 제목");
		map.put("C", "검색테스트 내용");
		map.put("W", "작성자");
		
		Map<String, Map<String, String>> outer = new HashMap<>();
		outer.put("map", map);
		
		List<BoardVO> list = mapper.searchTest(outer);
		list.forEach(l -> log.info(l));
	}
	
	@Test
	public void testSearch2() {
		
		Criteria cri = new Criteria();
		
		cri.setKeyword("Title");
		cri.setType("TC");
		
		mapper.getListWithPaging(cri)
			.forEach(list -> log.info(list));
		
	}
	
	
	@Test
	public void testTotalCount(){
		Criteria cri = new Criteria();
		cri.setKeyword("검색테스트");
		cri.setType("TC");
		int totalCount = mapper.getTotalCount(cri);
		log.info("totalCount --> " + totalCount);
		
	}
	
	
}
