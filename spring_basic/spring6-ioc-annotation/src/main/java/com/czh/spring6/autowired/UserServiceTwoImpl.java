package com.czh.spring6.autowired;

import org.springframework.stereotype.Service;

/**
 * @author godxiaocui
 * @date 2024/8/215:30
 */
@Service
public class UserServiceTwoImpl implements Userservice{
    @Override
    public void add() {
        System.out.println("userServiceTwo");
    }
}
