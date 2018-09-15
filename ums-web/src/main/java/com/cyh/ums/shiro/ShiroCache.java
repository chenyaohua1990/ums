package com.cyh.ums.shiro;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ShiroCache<K,V> implements Cache<K,V> {

    private static final String REDIS_SHIRO_CACHE = "shiro-cache:";
    private String cacheKey;
    private RedisTemplate<K, V> redisTemplate;
    private long globExpire = 60;

    public ShiroCache(String cacheKey, RedisTemplate<K, V> redisTemplate) {
        this.cacheKey = REDIS_SHIRO_CACHE+cacheKey+":";
        this.redisTemplate = redisTemplate;
    }

    private K getCacheKey(Object key){

        return  (K)(this.cacheKey+key);
    }

    @Override
    public V get(K k) throws CacheException {
        //每次获取将设置
        redisTemplate.boundValueOps(getCacheKey(k)).expire(globExpire, TimeUnit.MINUTES);
        return redisTemplate.boundValueOps(getCacheKey(k)).get();
    }

    @Override
    public V put(K k, V v) throws CacheException {
        V v1 = get(k);
        redisTemplate.boundValueOps(getCacheKey(k)).set(v);
        return v1;
    }

    @Override
    public V remove(K k) throws CacheException {
        V v = get(k);
        redisTemplate.delete(getCacheKey(k));
        return v;
    }

    @Override
    public void clear() throws CacheException {
        redisTemplate.delete(keys());
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Set<K> keys() {
        Set<K> keys = redisTemplate.keys(getCacheKey("*"));
        return keys;
    }

    @Override
    public Collection<V> values() {
        Set<K> keys = keys();
        List<V> list=new ArrayList<>();
        if(!CollectionUtils.isEmpty(keys)){
            for (K key : keys) {
                list.add(get(key));
            }
        }
        return list;
    }
}
