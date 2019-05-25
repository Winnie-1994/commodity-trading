package com.cmit.trading.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import com.cmit.trading.dao.DiningCal;
import com.cmit.trading.dao.DiningList;
import com.cmit.trading.dao.DiningList1;
import com.cmit.trading.dao.DiningUser;

/**
 * @author: wunt
 * @date: 2019-04-13
 * @description:
 */
@Repository
public class DiningTradeDao {

	@Autowired
	RedisTemplate<Object, Object> redisTemplate; // 2

	@Resource(name = "redisTemplate")
	ValueOperations<Object, Object> valOps; // 4

	DiningCal diningCal = new DiningCal();

	public void saveList(DiningUser diningUser, DiningList diningList) {
		diningCal.setCal(diningList);
		redisTemplate.opsForHash().put(diningUser.getNumber(), "用户信息", diningUser);
		redisTemplate.opsForHash().put(diningUser.getNumber(), "换购数量", diningList);
		redisTemplate.opsForHash().put(diningUser.getNumber(), "换购总价", diningCal.getCal());
	}

	public Map<String, Map<Object, Object>> getAllList() {
		Set<Object> numlist = redisTemplate.keys("1300*");
		Map<String, Map<Object, Object>> allList = new HashMap<String, Map<Object, Object>>();
		for (Object str : numlist) {
			Map<Object, Object> list = redisTemplate.opsForHash().entries(str);
			allList.put((String) str, list);
		}
		return allList;
	}

	public Map<Object, Object> getList(String number) {
		Map<Object, Object> list = redisTemplate.opsForHash().entries(number);
		return list;
	}

	public Set<Object> getNumList() {
		Set<Object> numlist = redisTemplate.keys("1300*");
		return numlist;
	}

	public Set<Object> getGoodList() {
		Set<Object> goodList = redisTemplate.opsForZSet().rangeByScore("GoodsList", 1, 33);
		return goodList;
	}

	public Object getGoodPrice(String goodName) {
		Object goodPrice = redisTemplate.opsForHash().get("GoodsPrice", goodName);
		return goodPrice;
	}

	public Set<DiningList1> getDiningList() {
		Set<DiningList1> diningList1 = null;
		DiningList1 diningList12;
		Set<Object> goodList = getGoodList();
		return diningList1;
	}
}
