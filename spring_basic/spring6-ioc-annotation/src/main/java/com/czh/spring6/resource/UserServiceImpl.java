package com.czh.spring6.resource;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author godxiaocui
 * @date 2024/8/214:13
 */
@Service("myUserService")
public class UserServiceImpl implements Userservice {

    @Resource
    private UserDao myUserDao;

    @Override
    public void add(){
        System.out.println("service resource...");
        myUserDao.add();
    }
}
