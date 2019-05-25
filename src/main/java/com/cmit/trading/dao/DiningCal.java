package com.cmit.trading.dao;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/** 
* @author: wunt
* @date: 2019-04-25 
* @description:
*/
@Setter
@Getter
@ToString
@Slf4j
public class DiningCal {
	private String value1 = "69.8";
	private String value2 = "69.8";
	private String value3 = "69.8";
	private String value4 = "38";
	private String value5 = "147";
	
	private String cal;
	
	public void setCal(DiningList diningList) {
		log.info("wunt");
		double cal1 = Integer.parseInt(diningList.getGood1()) * Double.parseDouble(value1);
		double cal2 = Integer.parseInt(diningList.getGood2()) * Double.parseDouble(value2);
		double cal3 = Integer.parseInt(diningList.getGood3()) * Double.parseDouble(value3);
		double cal4 = Integer.parseInt(diningList.getGood4()) * Double.parseDouble(value4);
		double cal5 = Integer.parseInt(diningList.getGood5()) * Double.parseDouble(value5);
		Double cal = (cal1 + cal2 + cal3 + cal4 + cal5);
		BigDecimal b = new BigDecimal(cal);
		cal = b.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
		this.cal = cal + "";
	}
	
}
