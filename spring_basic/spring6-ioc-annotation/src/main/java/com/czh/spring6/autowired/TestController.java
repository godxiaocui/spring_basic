package com.czh.spring6.autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author godxiaocui
 * @date 2024/8/214:32
 */
public class TestController {
    public static void main(String[] args) {
        ApplicationContext ac =new ClassPathXmlApplicationContext("bean.xml");
        UserController bean = ac.getBean(UserController.class);
        bean.add();
    }
}
