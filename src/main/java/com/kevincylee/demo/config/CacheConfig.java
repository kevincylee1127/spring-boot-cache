package com.kevincylee.demo.config;

import java.util.concurrent.TimeUnit;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.benmanes.caffeine.cache.Caffeine;

/**
 * ClassName: CacheConfig
 * 
 * @author Chen Yuan Lee (Kevin)
 * @version 1.0
 * @createTime: 2018/07/16 20:25:01
 */

@Configuration
@EnableCaching
public class CacheConfig {
	@Bean
	public CaffeineCacheManager cacheManager() {
		CaffeineCacheManager cacheManager = new CaffeineCacheManager();
		cacheManager.setCaffeine(Caffeine.newBuilder().maximumSize(10).expireAfterWrite(5, TimeUnit.SECONDS));
		return cacheManager;
	}

}
