package com.wei.xd_class.utils;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.mysql.cj.util.TimeUtil;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author www
 * @date 2022/6/29 22:14
 * @description:
 */

@Component
public class BaseCache {
    private Cache<String, Object> tenMinuteCache = CacheBuilder.newBuilder()
            // 设置缓存初始大小
            .initialCapacity(10)
            // 最大值
            .maximumSize(100)
            // 并发数
            .concurrencyLevel(5)
            // 过期时间, 10分钟后过期
            .expireAfterWrite(600, TimeUnit.SECONDS)
            // 统计缓存命中率
            .recordStats()
            .build();

    public Cache<String, Object> getTenMinuteCache() {
        return tenMinuteCache;
    }

    public void setTenMinuteCache(Cache<String, Object> tenMinuteCache) {
        this.tenMinuteCache = tenMinuteCache;
    }
}
