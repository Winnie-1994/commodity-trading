package com.cmit.trading;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
	
	@Test
	public void testDining() {
//		redisTemplate.opsForZSet().add("GoodsList", "香港南园杏仁500g", 1);
//		redisTemplate.opsForZSet().add("GoodsList", "香港南园腰果454g", 2);
//		redisTemplate.opsForZSet().add("GoodsList", "香港南园碧根果500g", 3);
//		redisTemplate.opsForZSet().add("GoodsList", "美国综合坚果250g", 4);
//		redisTemplate.opsForZSet().add("GoodsList", "刀唛花生油5L", 5);
//		redisTemplate.opsForZSet().add("GoodsList", "贡庭东北米5KG", 6);
//		redisTemplate.opsForZSet().add("GoodsList", "贡庭茉莉香米5KG", 7);
//		redisTemplate.opsForZSet().add("GoodsList", "贡庭黑土稻花香米5KG", 8);
//		redisTemplate.opsForZSet().add("GoodsList", "孟乍隆乌汶香米5KG", 9);
//		redisTemplate.opsForZSet().add("GoodsList", "椰树椰子汁245ML", 10);
//		redisTemplate.opsForZSet().add("GoodsList", "晨光鲜奶236ML", 11);
//		redisTemplate.opsForZSet().add("GoodsList", "晨光酸奶236ML", 12);
//		redisTemplate.opsForZSet().add("GoodsList", "卡士原太125G*3", 13);
//		redisTemplate.opsForZSet().add("GoodsList", "卡士活菌200G*3", 14);
//		redisTemplate.opsForZSet().add("GoodsList", "优益C340ML", 15);
//		redisTemplate.opsForZSet().add("GoodsList", "本来生活365每日坚果25g*30袋", 16);
//		redisTemplate.opsForZSet().add("GoodsList", "轩妈蛋黄酥紫薯味330g", 17);
//		redisTemplate.opsForZSet().add("GoodsList", "新西兰 维必滋 麦卢卡混合蜂蜜 500g", 18);
//		redisTemplate.opsForZSet().add("GoodsList", "恒大米油组合(油4L、米5kg)", 19);
//		redisTemplate.opsForZSet().add("GoodsList", "贝蒂斯BETIS特级初榨橄榄油500ml*2L", 20);
//		redisTemplate.opsForZSet().add("GoodsList", "曼蒂特伦尼橄榄油500mL*2", 21);
//		redisTemplate.opsForZSet().add("GoodsList", "臻品干货礼盒本来生活臻品干货礼盒（6种）", 22);
//		redisTemplate.opsForZSet().add("GoodsList", "本来生活山川丰饶干货礼盒1.108kg", 23);
//		redisTemplate.opsForZSet().add("GoodsList", "东北响水石板大米分享礼盒2.5kg", 24);
//		redisTemplate.opsForZSet().add("GoodsList", "本来生活五常李玉双有机稻花香大米5kg", 25);
//		redisTemplate.opsForZSet().add("GoodsList", "本来生活长粒香大米5kg", 26);
//		redisTemplate.opsForZSet().add("GoodsList", "爱粗粮杂粮礼盒（6种）2.4kg", 27);
//		redisTemplate.opsForZSet().add("GoodsList", "本来生活有机杂粮礼盒（10种）3.59kg", 28);
//		redisTemplate.opsForZSet().add("GoodsList", "乐扣套装 便当盒饭盒3件套(470ml/850ml/1300ml)", 29);
//		redisTemplate.opsForZSet().add("GoodsList", "向日葵高筋小麦粉2.5kg", 30);
//		redisTemplate.opsForZSet().add("GoodsList", "君子兰馒头粉2.5kg", 31);
//		redisTemplate.opsForZSet().add("GoodsList", "向日葵高筋小麦粉5kg", 32);
//		redisTemplate.opsForZSet().add("GoodsList", "君子兰馒头粉5kg", 33);
//		Set<Object> dininglist =  redisTemplate.opsForZSet().rangeByScore("GoodsList", 1, 33);
//		Map<Object, Object> tlist =  redisTemplate.opsForHash().entries("GoodsPrice");
		Object olist =  redisTemplate.opsForHash().get("GoodsPrice", "香港南园杏仁500g");
//		System.out.println(dininglist);
//		System.out.println(tlist);
		System.out.println(olist);
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
