package org.spr.service;

import java.util.List;

import org.spr.domain.BotestVO;

public interface BotestService {
	
	public void register(BotestVO board);
	
	public BotestVO get(Long bno);
	
	public boolean modify(BotestVO board);
	
	public boolean remove(Long bno);
	
	public List<BotestVO> getList();

}
