package com.cmit.trading.redis.config;

import java.net.UnknownHostException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

/** 
* @author: wunt
* @date: 2018-11-04 
* @description:
*/
@Configuration
public class RedisTemplateConfiguration {
	
	
	/**
	 * 
	 * @param redisConnectionFactory
	 * @return
	 */
    @Bean(name = "jsonRedisTemplate")
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<Object, Object> template = new RedisTemplate<Object, Object>();
		template.setConnectionFactory(redisConnectionFactory);
		
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);  
		ObjectMapper om = new ObjectMapper();  
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);  
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);  
        jackson2JsonRedisSerializer.setObjectMapper(om);  
        
        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(jackson2JsonRedisSerializer);
        
        template.afterPropertiesSet();  
		return template;
	}


	@Bean(name = "stringRedisTemplate")
	public RedisTemplate<String, String> stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<String, String> template = new RedisTemplate<>();
		template.setConnectionFactory(redisConnectionFactory);

		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(om);

		template.setValueSerializer(new StringRedisSerializer());
		template.setKeySerializer(new StringRedisSerializer());
		template.setHashKeySerializer(new StringRedisSerializer());
		template.setHashValueSerializer(new StringRedisSerializer());

		template.afterPropertiesSet();
		return template;
	}
    
}
