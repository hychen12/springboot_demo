package com.example.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.UUID;

@Controller
public class Login {


    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplate redisTemplate;

    @RequestMapping(value="/")
    public String home(){
        return "home";
    }

    @RequestMapping(value = "/uid")
    public String sessionTest(HttpSession session){
        UUID uid = (UUID) session.getAttribute("uid");
        if(uid == null)
            uid = UUID.randomUUID();
        session.setAttribute("uid", uid);
        return "home";
    }

    @RequestMapping(value = "/getuid")
    public String sessionGet(HttpSession session){
        Map redisdata = redisTemplate.opsForHash().entries("spring:session:sessions:"+session.getAttribute("uid"));

        System.out.println("session id value :"+redisdata.get("sessionAttr:uid"));
        return "home";
    }
}
