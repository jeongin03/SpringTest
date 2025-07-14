package org.spr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.spr.domain.BotestVO;

public interface BotestMapper {
	// interface는 클래스와 다르게 메서드가 추상화임.
	
	@Select("SELECT * FROM tes_board WHERE bno > 0")// bno > 0 pk로 선언되어있어서 인덱싱으로 빠른 추출
	public List<BotestVO> getList(); 
	
	public List<BotestVO> getList2(); // xml을 이용한 쿼리 처리 매퍼용 메서드
	
	public void insert(BotestVO board); // xml에서 쿼리 작성
	
	public void insertSelectKey(BotestVO board); // xml에서 쿼리 작성
	
	public BotestVO read(Long bno); // xml에서 쿼리 작성
	
	public int update(BotestVO board); // xml에서 쿼리 작성

	public int delete(Long bno);
	

}
