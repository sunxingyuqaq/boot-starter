package com.boot.study.jpa.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @author Xingyu Sun
 * @version 1.0
 * @date 2020/7/7 14:23
 * @apiNote
 * @see Object
 * @since jdk1.8
 */
@Configuration
@EnableCaching
public class CaffeineConfiguration {

    public static final long DEFAULT_MAXSIZE = 10000L;
    public static final int DEFAULT_INIT_SIZE = 100;
    public static final int DEFAULT_TTL = 1800;

    /**
     * 创建基于Caffeine的Cache Manager
     *
     * @return CacheManager
     */
    @Bean
    public CacheManager caffeineCacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        cacheManager.setCaffeine(Caffeine.newBuilder()
                .initialCapacity(DEFAULT_INIT_SIZE)
                .maximumSize(DEFAULT_MAXSIZE)
                .expireAfterAccess(DEFAULT_TTL, TimeUnit.SECONDS));
        return cacheManager;
    }

    @Bean
    public KeyGenerator cacheKeyGenerator(){
        return new CacheKeyGenerator();
    }
}
