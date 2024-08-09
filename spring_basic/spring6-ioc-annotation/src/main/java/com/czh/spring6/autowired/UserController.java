package com.czh.spring6.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * @author godxiaocui
 * @date 2024/8/214:12
 */
@Controller
public class UserController {

    @Autowired
    @Qualifier("userServiceTwoImpl")
    private Userservice userservice;

    public void add(){
        System.out.println("controller");
        userservice.add();
    }
}
