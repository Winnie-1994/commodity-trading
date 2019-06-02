package com.cmit.trading;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.cmit.trading.domain.CommodityTradingDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/** 
* @author: wunt
* @date: 2019-04-16 
* @description:
*/
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestRedisTemplate {

	@Autowired
	private RedisTemplate<Object, Object> redisTemplate;

	@Autowired
	private CommodityTradingDao commodityTradingDao;

//	@Test
	public void test () {
		redisTemplate.opsForHash().put("13001445", "碧根果", new Student("1000", "caiwj"));
	}
	
//	@Test
	public void testKeys () {
		redisTemplate.opsForHash().put("13001444", "用户信息", "a");
		redisTemplate.opsForHash().put("13001445", "换购信息", "b");
		Map<Object, Object> list =  redisTemplate.opsForHash().entries("13001444");
		
		Set<Object> numlist = redisTemplate.keys("1300*");
		Map<String, Map<Object, Object>> aList = new HashMap<String, Map<Object, Object>>();
		for(Object str : numlist) {
			Map<Object, Object> tlist =  redisTemplate.opsForHash().entries(str);
			aList.put((String) str, tlist);
		} 
		
		System.out.println(list);
		System.out.println(aList);
	}

	class Student {
		private String stuNo;
		private String name;

		public Student(String stuNo, String name) {
			super();
			this.stuNo = stuNo;
			this.name = name;
		}
		public String getStuNo() {
			return stuNo;
		}
		public void setStuNo(String stuNo) {
			this.stuNo = stuNo;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}

	}

}
