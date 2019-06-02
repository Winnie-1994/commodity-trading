/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: TestCommodityTradingDao
 * Author:   lenovo
 * Date:     2019-05-31 22:48
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cmit.trading;

import com.cmit.trading.dao.Commodity;
import com.cmit.trading.dao.CommodityTrading;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author lenovo
 * @create 2019-05-31
 * @since 1.0.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestCommodityTradingDao {

    @Autowired
    @Qualifier("stringRedisTemplate")
    private RedisTemplate<String, String> stringRedisTemplate;

    @Autowired
    @Qualifier("jsonRedisTemplate")
    private RedisTemplate<Object, Object> jsonRedisTemplate;

    @Test
    public void testGetCommodity(){
        Integer hashKey = 1;
        Integer hasKey_Max = 33;
        ArrayList<Commodity> allCommodity = new ArrayList<>();

        for (;hashKey <= hasKey_Max; hashKey++){
            Commodity commodity = new Commodity();
            commodity.setCommodityId(hashKey);
            commodity.setCommodityName((String) stringRedisTemplate.opsForHash().get("CommodityIdAndName", hashKey.toString()));
            commodity.setCommodityPrice((String) stringRedisTemplate.opsForHash().get("CommodityIdAndPrice", hashKey.toString()));
            allCommodity.add(commodity);
        }

//        System.out.println(allCommodity);
        for(Commodity acommodity:allCommodity) {
            System.out.print(acommodity.getCommodityId());
            System.out.print(acommodity.getCommodityName());
            System.out.print(acommodity.getCommodityPrice());
            System.out.println("");
        }

    }

//    @Test
//    public void setCommoditingTrading(CommodityTrading commoditingTrading){
//        jsonRedisTemplate.opsForHash().put(commoditingTrading.getCommodityUser().getUserNumber(), "用户信息", commoditingTrading.getCommodityUser());
//        jsonRedisTemplate.opsForHash().put(commoditingTrading.getCommodityUser().getUserNumber(), "换购数量", commoditingTrading.getCommodityTradingList());
//        jsonRedisTemplate.opsForHash().put(commoditingTrading.getCommodityUser().getUserNumber(), "换购总价", commoditingTrading.getCommodityTradingTotalPrice());
//    }
}
