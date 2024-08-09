package com.czh.spring6.resource;

import com.czh.spring6.config.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author godxiaocui
 * @date 2024/8/214:32
 */
public class TestController {
    public static void main(String[] args) {
        ApplicationContext ac =new AnnotationConfigApplicationContext(SpringConfig.class);
        UserController bean = ac.getBean("myUserController",UserController.class);
        bean.add();
    }
}
