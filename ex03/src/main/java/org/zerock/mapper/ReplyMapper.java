package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

public interface ReplyMapper {
	
	//댓글 등록
	public int insert(ReplyVO replyVO);
	
	public ReplyVO read(Long rno);
	
	public int delete(Long rno);
	
	public int update(ReplyVO replyVO);
	
	public List<ReplyVO> getList(Long bno);
	
	// Mybatis는 인자값 2개이상 전달 시 @Param으로 명시 필요
	public List<ReplyVO> getListWithPaging(
			@Param("cri") Criteria cri, 
			@Param("bno") Long bno
			);
	
	public int getCountByBno(Long bno);
	
}
