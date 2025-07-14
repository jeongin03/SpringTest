package org.spr.service;

import java.util.List;

import org.spr.domain.BotestVO;
import org.spr.mapper.BotestMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@AllArgsConstructor
@Log4j2
public class BotestServicelmpl implements BotestService {

	public BotestMapper mapper;

	@Override
	public void register(BotestVO board) {
		// 객체가 넘어오면 메퍼를 이용해서 데이터베이스에 등록함.

		log.info("BoardServiceImpl.register메서드 실행.....");

		mapper.insertSelectKey(board);
		log.info("정상등록 후 리스트 출력테스트......");
		mapper.getList2();

	}

	@Override
	public BotestVO get(Long bno) {
		// 게시물의 번호가 들어가면 메퍼의 select문이 동작해야 한다.
		log.info("BoardServiceImpl.get메서드 실행.....");

		return mapper.read(bno);
	}

	@Override
	public boolean modify(BotestVO board) {
		// 프론트에서 객체가 넘어오면 매퍼를 통해서 update 쿼리가 실행된다.
		log.info("BoardServiceImpl.modify메서드 실행.....");
		return mapper.update(board) == 1;
	}

	@Override
	public boolean remove(Long bno) {
		// 프론트에서 번호가 넘어오면 매퍼를 통해서 delete 쿼리가 실행된다.
		log.info("BoardServiceImpl.remove메서드 실행.....");
		return mapper.delete(bno) == 1;
	}

	@Override
	public List<BotestVO> getList() {
		// getList() 메서드가 호출되면 매퍼에 getLIst2()를 호출한다.
		log.info("BoardServiceImpl.getList 메서드 실행.....");

		return mapper.getList2();
	}

}
