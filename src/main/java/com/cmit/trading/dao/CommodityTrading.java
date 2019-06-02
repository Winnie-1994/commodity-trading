/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: CommodityTrading
 * Author:   lenovo
 * Date:     2019-05-25 20:00
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cmit.trading.dao;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author wunt
 * @create 2019-05-25
 * @since 1.0.0
 */
@Getter
@Setter
public class CommodityTrading {

    private CommodityUser commodityUser;

    private Map<Integer, String> commidityTradingAmount;

    private Double commodityTradingTotalPrice;

}
