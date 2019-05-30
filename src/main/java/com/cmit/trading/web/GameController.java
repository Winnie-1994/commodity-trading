package com.cmit.trading.web;

import java.io.IOException;
import java.util.List;

import com.cmit.trading.dao.Commodity;
import com.cmit.trading.dao.CommodityTrading;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cmit.trading.service.CommodityTradingService;

/**
* @author      : Vander
* @date        : 2018-08-02
* @description ： 
*/
@Controller
public class GameController {
	
	@Autowired
	private CommodityTradingService diningTradeService;

	@RequestMapping(value="/start", method= {RequestMethod.POST, RequestMethod.GET})
	public String start() {
		return "game";
	}
	
	@RequestMapping(value="/register", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView register(@ModelAttribute CommodityTrading commodityTrading) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("game");
		return mv;
	}
	

	
}
