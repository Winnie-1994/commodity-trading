package com.cmit.trading.web;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cmit.trading.dao.DiningList;
import com.cmit.trading.dao.DiningUser;
import com.cmit.trading.service.DiningTradeService;

/**
* @author      : Vander
* @date        : 2018-08-02
* @description ： 
*/
@Controller
public class GameController {
	
	@Autowired
	private DiningTradeService DiningTradeService;
	
	@RequestMapping(value="/start", method= {RequestMethod.POST, RequestMethod.GET})
	public String start() {
		return "game";
	}
	
	@RequestMapping(value="/register", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView register(@ModelAttribute DiningList diningList, @ModelAttribute DiningUser diningUser) {
		DiningTradeService.saveList(diningUser, diningList);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("game");
		return mv;
	}
	
	@RequestMapping(value="/downloadExcel", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView  downloadExcel() throws IOException {
//		DiningTradeService.getList("13001444");
		DiningTradeService.downloadExcel();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("game");
		return mv;
	}
	
}
