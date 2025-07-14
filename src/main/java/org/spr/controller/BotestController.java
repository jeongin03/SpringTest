package org.spr.controller;



import org.spr.domain.BotestVO;
import org.spr.service.BotestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller // url분기와 jsp 연동 담당.
@Log4j2
@RequestMapping("/board/*") // * 모든 경로
@AllArgsConstructor // 생성자 자동 주입
public class BotestController {

	private BotestService service; // 필드

	@GetMapping("/list")
	public void list(Model model) {
		log.info("BoardVController.list 메서드 실행...............");

		model.addAttribute("list", service.getList());
	}
	@GetMapping("/register")
	public String register() {
		return "/board/register";
	}
	
	@PostMapping("/register")
	public String register(BotestVO board, RedirectAttributes rttr) {
		log.info("BoardVController.register 메서드 실행........");
		service.register(board);
		return "redirect:/board/list";
	}
	
	@GetMapping({ "/get", "/modify" })
	public void get(@RequestParam("bno") Long bno, Model model) {
		log.info("BoardVController.get 메서드 실행........");

		model.addAttribute("board", service.get(bno));
	}
	
	@PostMapping("/modify")
	public String modify(BotestVO board, RedirectAttributes rttr) {
		log.info("BoardVController.get 메서드 실행........");

		if (service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
	
	@PostMapping("/remove") // http://192.168.111.104:80/board/remove
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		log.info("BoardVController.remove 메서드 실행........");

		if (service.remove(bno)) {
			// 서비스에 다녀온 결과가 true면 아래 실행문을 실행
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}

}
