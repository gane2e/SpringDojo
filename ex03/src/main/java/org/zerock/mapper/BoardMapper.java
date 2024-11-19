package org.zerock.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardMapper {

//	@Select("select * from tbl_board where bno > 0")
	
	//게시물 목록
	public List<BoardVO> getList();
	
	//검색조건+페이징
	public List<BoardVO> getListWithPaging(Criteria cri);
	
	//1개 게시물만 조회
	public void insertSelectKey(BoardVO vo);
	
	//게시물 등록
	public void insert(BoardVO boardVO);
	
	//게시물 조회
	public BoardVO read(Long bno);
	
	//게시물 삭제
	public int delete(Long bno);
	
	//게시물 수정
	public int update(BoardVO boardVO);
	
	//전체 데이터 개수
	public int getTotalCount(Criteria cri); 
	
	//test용
	public List<BoardVO> searchTest(Map<String, Map<String, String>> map);
}
