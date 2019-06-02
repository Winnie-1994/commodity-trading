package com.cmit.trading.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.cmit.trading.dao.Commodity;
import com.cmit.trading.dao.CommodityTrading;
import com.cmit.trading.dao.CommodityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	private CommodityTradingService commodityTradingService;

	@RequestMapping(value="/start", method= {RequestMethod.GET})
	public String start(Model model) {
		ArrayList<Commodity> commodityList = commodityTradingService.getCommodityList();
		model.addAttribute("commodityList", commodityList);
		model.addAttribute("commodityUser", new CommodityUser());
		return "game";
	}
	
	@RequestMapping(value="/register", method= {RequestMethod.POST})
	public ModelAndView register(@ModelAttribute CommodityUser commodityUser) {
		commodityTradingService.setCommodityUser(commodityUser);
		ModelAndView mv = new ModelAndView();
		ArrayList<Commodity> commodityList = commodityTradingService.getCommodityList();
		mv.addObject("commodityList", commodityList);
		mv.addObject("commodityUser", new CommodityUser());
		mv.setViewName("game");
		return mv;
	}
	

	
}
