package com.czh.spring6.resource;

import com.czh.spring6.User;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * @author godxiaocui
 * @date 2024/8/214:12
 */
@Controller("myUserController")
public class UserController {

    @Resource(name = "myUserService")
    private Userservice userservice;

    public void add(){
        System.out.println("controller resource");
        userservice.add();
    }
}
