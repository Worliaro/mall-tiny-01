package com.macro.mall.tiny.service;

/**
 * @Classname RedisService
 * @Description redis操作Service【对象和数组都以json形式进行存储】
 * @Date 2020/7/3 14:57
 * @Creater by weiyao
 */
public interface RedisService {

    /**
     * 存储数据
     * @param key
     * @param value
     */
    void set(String key, String value);

    /**
     * 获取数据
     * @param key
     * @return
     */
    String get(String key);

    /**
     * 设置超期时间
     * @param key
     * @param expire
     * @return
     */
    boolean expire(String key,long expire);

    /**
     * 删除数据
     * @param key
     */
    void remove(String key);

    /**
     * 自增操作
     * @param key
     * @param delta
     * @return
     */
    Long increment(String key,long delta);

}
