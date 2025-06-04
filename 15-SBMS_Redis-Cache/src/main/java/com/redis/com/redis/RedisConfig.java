package com.redis.com.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.redis.com.entity.User;

@Configuration
public class RedisConfig {

	@Bean
	public JedisConnectionFactory getConnectionFactory() {
		JedisConnectionFactory factory = new JedisConnectionFactory();
		// factory.setHostName(hostName);
		// factory.setPassword(password);
		// factory.setPort(port);
		return factory;

	}

	@Bean
	public RedisTemplate<String, User> getRedisTemplate(JedisConnectionFactory factory) {
		RedisTemplate<String, User> rt= new RedisTemplate<>();
		rt.setConnectionFactory(factory);
		
		return rt;
	}
}
