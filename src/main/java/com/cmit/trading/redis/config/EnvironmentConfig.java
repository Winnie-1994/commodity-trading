/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: EnvironmentConfig
 * Author:   lenovo
 * Date:     2019-05-26 16:05
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cmit.trading.redis.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import  org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author lenovo
 * @create 2019-05-26
 * @since 1.0.0
 */
@Configuration
public class EnvironmentConfig {

    @Autowired
    private ApplicationContext applicationContext;

    @PostConstruct
    public void showBeans() {
        String[]  beanNames = applicationContext.getBeanDefinitionNames();
        for(String beanName : beanNames) {
            System.out.println(beanName);
        }
    }


}
