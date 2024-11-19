package com.mvc.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MainClass {

	public static void main(String[] args) {

		String resource = "com/mvc/controller/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
			System.out.println("sqlSessionFactory : " + sqlSessionFactory);
			
			SqlSession session = sqlSessionFactory.openSession(true);
			
			System.out.println("session : " + session);
			
			
			BoardDTO dto = new BoardDTO();
			
			BoardMapper mapper = session.getMapper(BoardMapper.class);
			/* 단건조회
			dto = mapper.selectOne(50);
			*/
			
			/* 전체조회
			List<BoardDTO> lists = mapper.selectAllList();
			for(BoardDTO list : lists) {
				System.out.println(list);
			}
			*/

			/* 삭제
			int result = mapper.deleteBoard(116);
			System.out.println(result);
			*/
			
			dto.setTitle("마이바티스");
			dto.setContent("마이바티스로 입력중..");
			dto.setNum(115);
			
			
			int result = mapper.updateBoard(dto);
			System.out.println(result);
			
//			dto.setNum(200);
//			dto.setTitle("마이바티스");
//			dto.setContent("마이바티스로 입력중..");
//			dto.setId("mybatis00");
//			dto.setVisitcount(0);
//			dto.setPostdate(new java.util.Date());
			
			
			// Blog blog = session.selectOne("org.mybatis.example.BlogMapper.selectBlog", 101);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
