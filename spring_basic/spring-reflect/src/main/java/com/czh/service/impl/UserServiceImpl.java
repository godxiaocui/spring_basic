package com.czh.service.impl;

import com.czh.ano.Bean;
import com.czh.ano.Di;
import com.czh.dao.UserDao;

/**
 * @author godxiaocui
 * @date 2024/8/217:14
 */

@Bean
public class UserServiceImpl implements UserService{

    @Di
    private UserDao userDao;

    @Override
    public void add() {
        System.out.println("ano service......");
        //调用dao的方法
        userDao.add();
    }
}
