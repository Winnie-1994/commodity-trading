/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Commodity
 * Author:   lenovo
 * Date:     2019-05-26 17:19
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cmit.trading.dao;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author lenovo
 * @create 2019-05-26
 * @since 1.0.0
 */
@Getter
@Setter
public class Commodity {
    private Integer commodityId;
    private String commodityName;
    private  String commodityPrice;
}
