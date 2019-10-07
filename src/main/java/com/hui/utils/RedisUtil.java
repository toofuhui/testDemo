package com.hui.utils;

import com.alibaba.druid.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {
    @Autowired
    private RedisTemplate redisTemplate;
    /**
     *     * @param key

     */
    public void delete(String key){
        redisTemplate.delete(key);
    }

    /**
     * 批量删除
     * @param keys
     */
    public void delete(Collection<String > keys){
        redisTemplate.delete(keys);
    }

    /**
     * 设置过期时间
     * @param key
     * @param timeout
     * @param unit
     * @return
     */
    public Boolean expire(String key, long timeout, TimeUnit unit) {
        return redisTemplate.expire(key, timeout, unit);
    }

    /**
     * 设置指定 key 的值
     * @param key
     * @param value
     */
    public void set(String key,String value){
        if (StringUtils.isEmpty(key) || StringUtils.isEmpty(value)) {
            return;
        }
        redisTemplate.opsForValue().set(key,value);
    }

    /**
     * 获取指定 key 的值
     * @param key
     * @return
     */
    public String get(String key){
        return (String) redisTemplate.opsForValue().get(key);
    }
    /**
     * 是否存在key
     *
     * @param key
     * @return
     */
    public boolean hasKey(String key){
        return redisTemplate.hasKey(key);

    }
}