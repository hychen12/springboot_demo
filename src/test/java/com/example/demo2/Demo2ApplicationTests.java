package com.example.demo2;

import org.apache.catalina.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo2ApplicationTests {

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void contextLoads() {
        System.out.println("test pass");
    }

    @Test
    public void testReids() {
        stringRedisTemplate.opsForValue().set("aaa","111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));

    }

//    @Test
//    public void testReidsObj() {
//        User u = new User("abc");
//        ValueOperations<String, User> operations = redisTemplate.opsForValue();
//        operations.set("usss",u);
//
//        Assert.assertEquals("usss", operations.get("usss").getName());
//
//    }
//
//    public class User implements Serializable {
//        private String name;
//        public User(String name){
//            this.name = name;
//        }
//        public String getName() {return name;}
//    }

}
