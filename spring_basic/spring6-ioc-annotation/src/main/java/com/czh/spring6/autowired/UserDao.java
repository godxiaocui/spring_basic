package com.czh.spring6.autowired;

import org.springframework.stereotype.Repository;

/**
 * @author godxiaocui
 * @date 2024/8/214:12
 */
@Repository
public class UserDao {
    public void add(){
        System.out.println("add.....");
    }
}
