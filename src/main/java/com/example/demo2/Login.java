package com.example.demo2;

import org.springframework.stereotype.Controller;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@Controller
public class Login {
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
}
