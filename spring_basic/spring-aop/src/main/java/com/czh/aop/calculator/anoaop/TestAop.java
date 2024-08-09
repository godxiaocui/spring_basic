package com.czh.aop.calculator.anoaop;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author godxiaocui
 * @date 2024/8/417:25
 */
public class TestAop {

    @Test
    public void testAdd(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        Calculator bean = ac.getBean(Calculator.class);
        bean.add(1,2);
    }
}
