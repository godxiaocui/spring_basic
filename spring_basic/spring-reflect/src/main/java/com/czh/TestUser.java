package com.czh;

import com.czh.bean.AnnotationApplicationContext;
import com.czh.bean.ApplicationContext;
import com.czh.service.impl.UserService;

/**
 * @author godxiaocui
 * @date 2024/8/416:17
 */
public class TestUser {

    public static void main(String[] args) {
        ApplicationContext context=new AnnotationApplicationContext("com.czh");
        UserService bean =(UserService) context.getBean(UserService.class);
        bean.add();
    }
}
