package com.bitacademy.mysite.repository;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.bitacademy.mysite.vo.BoardVo;
import com.bitacademy.mysite.vo.GuestbookVo;


@Repository
public class BoardRepository {
	
	@Autowired
	private SqlSession sqlSession;
	
	 //1. 게시물 리스트보기
	 public List<BoardVo> findAll() {
		 
		  return sqlSession.selectList("board.findAll");
		
	}
	
	//2. 게시물작성
	public boolean insert(BoardVo vo) {

		int count = sqlSession.insert("board.insert",vo);
		return count ==1;	

	}
	
	//3. 게시물보기
	public List<BoardVo> select(BoardVo vo){

		return sqlSession.selectOne("board.select", vo);
		
	}
	
	//4. 게시물 수정하기
	//public boolean Update(BoardVo vo) {
	
		
		
		
		
	
	//}
	
	
	//4. 게시물삭제
	public boolean delete(GuestbookVo vo) {
		
		int count = sqlSession.delete("guestbook.delete", vo);
		return count ==1;	
	}
}
