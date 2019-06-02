package com.cmit.trading.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import com.cmit.trading.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    @Qualifier("jsonRedisTemplate")
    private RedisTemplate<Object, Object> jsonRedisTemplate;

    @Autowired
    @Qualifier("stringRedisTemplate")
    private RedisTemplate<String, String> stringRedisTemplate;

    public ArrayList<Commodity> getCommodityList() {
        Integer hashKey = 1;
        Integer hasKey_Max = 33;
        ArrayList<Commodity> commodityList = new ArrayList<>();

        for (; hashKey <= hasKey_Max; hashKey++) {
            Commodity commodity = new Commodity();
            commodity.setCommodityId(hashKey);
            commodity.setCommodityName((String) stringRedisTemplate.opsForHash().get("CommodityIdAndName", hashKey.toString()));
            commodity.setCommodityPrice((String) stringRedisTemplate.opsForHash().get("CommodityIdAndPrice", hashKey.toString()));
            commodityList.add(commodity);
        }

        return commodityList;
    }

    public void setCommoditingTrading(CommodityTrading commoditingTrading){
        jsonRedisTemplate.opsForHash().put(commoditingTrading.getCommodityUser().getUserNumber(), "用户信息", commoditingTrading.getCommodityUser());
//        jsonRedisTemplate.opsForHash().put(commoditingTrading.getCommodityUser().getUserNumber(), "换购数量", commoditingTrading.getCommodityTradingList());
//        jsonRedisTemplate.opsForHash().put(commoditingTrading.getCommodityUser().getUserNumber(), "换购总价", commoditingTrading.getCommodityTradingTotalPrice());
    }

    public void setCommodityUser(CommodityUser commodityUser){
        jsonRedisTemplate.opsForHash().put(commodityUser.getUserNumber(), "用户信息", commodityUser);
    }

}
