package com.czh.spring6.resource;

import org.springframework.stereotype.Repository;

/**
 * @author godxiaocui
 * @date 2024/8/214:12
 */
@Repository("myUserDao")
public class UserDao {
    public void add(){
        System.out.println("add mydao.....");
    }
}
