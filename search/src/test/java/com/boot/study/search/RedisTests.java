package com.boot.study.search;

import cn.hutool.json.JSONUtil;
import com.boot.study.tests.BaseWebApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author Xingyu Sun
 * @version 1.0
 * @date 2020/9/22 17:01
 * @apiNote
 * @see Object
 * @since jdk1.8
 */
@Slf4j
public class RedisTests extends BaseWebApplicationTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void insert() {
        for (int i = 0; i < 10; i++) {
            stringRedisTemplate.opsForValue().set("name" + i, "sxy" + i);
        }
        for (int i = 0; i < 10; i++) {
            stringRedisTemplate.opsForSet().add("date" + i, "eee" + i, "www" + i, "xxx" + i, "ccc" + i);
        }
        for (int i = 0; i < 10; i++) {
            Map<String, String> map = new HashMap<>();
            map.put("name", "sxy" + i);
            map.put("age", String.valueOf(i));
            stringRedisTemplate.opsForHash().putAll(UUID.randomUUID().toString(), map);
        }
        for (int i = 0; i < 10; i++) {
            Map<String, String> map = new HashMap<>();
            map.put("name", "sxy" + i);
            map.put("age", String.valueOf(i));
            stringRedisTemplate.opsForValue().set("json"+i, JSONUtil.toJsonStr(map));
        }

    }
}
