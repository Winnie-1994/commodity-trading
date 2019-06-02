package com.cmit.trading.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

import com.cmit.trading.dao.*;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmit.trading.domain.CommodityTradingDao;


/**
* @author: wunt
* @date: 2019-04-15
* @description:
*/
@Service
public class CommodityTradingService {

	@Autowired
	CommodityTradingDao commodityTradingDao;

	public ArrayList<Commodity> getCommodityList(){
		ArrayList<Commodity> commodityList = commodityTradingDao.getCommodityList();
		return commodityList;
	}

	public void setCommoditingTrading(CommodityTrading commoditingTrading){
		commodityTradingDao.setCommoditingTrading(commoditingTrading);
	}

	public void setCommodityUser(CommodityUser commodityUser){
		commodityTradingDao.setCommodityUser(commodityUser);
	}

}
