package com.zsl.easyexcelpro.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * 此缓存演示如何结合redis自增数 hash 本地缓存使用进行设备自增数的生成、缓存、本地缓存
 * 本地缓存使用 Guava Cache
 */
public class DeviceIncCache {

    /**
     * 本地缓存
     */
    private Cache<String, Integer> localCache = CacheBuilder.newBuilder()
            .concurrencyLevel(16)   // 并发级别
            .initialCapacity(1000)  // 初始容量
            .maximumSize(10000)     // 缓存最大长度
            .expireAfterAccess(1, TimeUnit.HOURS)   // 缓存1小时没被使用就过期
            .build();

    @Autowired
    private RedisTemplate<String, Integer> redisTemplate;

    /**
     * redis 自增缓存的 key
     */
    private static final String DEVICE_INC_COUNT = "device_inc_count";

    /**
     * redis 设备编码对应自增数的 hash 缓存 key
     */
    private static final String DEVICE_INC_VALUE = "device_inc_value";

    /**
     * 获取设备自增数
     */
    public int getInc(String deviceCode) {
        // 1.从本地缓存获取
        Integer inc = localCache.getIfPresent(deviceCode);
        if (Objects.nonNull(inc)) {
            return inc;
        }
        // 2.本地缓存未命中，从redis的hash缓存获取
        inc = (Integer) redisTemplate.opsForHash().get(DEVICE_INC_VALUE, deviceCode);
        // 3. redis 的 hash 缓存中没有，说明是新设备，先为设备生成一个自增号
        if (Objects.isNull(inc)) {
            inc = redisTemplate.opsForValue().increment(DEVICE_INC_COUNT).intValue();
            // 添加到 redis hash 缓存
            redisTemplate.opsForHash().put(DEVICE_INC_VALUE, deviceCode, inc);
        }
        // 4.添加本地缓存
        localCache.put(deviceCode, inc);
        // 5.返回自增数
        return inc;
    }
}
