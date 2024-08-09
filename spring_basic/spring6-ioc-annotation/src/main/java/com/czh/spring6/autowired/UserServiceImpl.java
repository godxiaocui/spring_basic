package com.czh.spring6.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author godxiaocui
 * @date 2024/8/214:13
 */
@Service
public class UserServiceImpl implements Userservice{

    @Autowired
    private UserDao userDao;

    @Override
    public void add(){
        System.out.println("service...");
        userDao.add();
    }
}
