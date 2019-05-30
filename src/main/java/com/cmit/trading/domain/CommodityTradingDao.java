package com.cmit.trading.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import com.cmit.trading.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

/**
 * @author: wunt
 * @date: 2019-04-13
 * @description:
 */
@Repository
public class CommodityTradingDao {

	@Autowired
	private RedisTemplate<Object, Object> redisTemplate; // 2

	CommodityUser commodityUser;

	//	public Set<Commodity> getCommodity(){
//		Set<Object> commodityList = redisTemplate.opsForZSet().rangeByScore("CommoditySorted", 1, 33);
//		redisTemplate.opsForZSet().score("CommoditySorted", "香港南园杏仁500g");
//
//
//	}

	public Set<Object> getAllCommodityList() {
		Set<Object> allCommodityList = redisTemplate.opsForZSet().rangeByScore("CommoditySorted", 1, 33);
		return allCommodityList;
	}

	public Object getCommodityPrice(Object commodityName) {
		Object commodityPrice = redisTemplate.opsForHash().get("Commodity", commodityName);
		return commodityPrice;
	}

	public Map<Object, Object> getAllCommodityPrice() {
		Map<Object, Object> allCommodityPrice = redisTemplate.opsForHash().entries("Commodity");
		return allCommodityPrice;
	}



}
