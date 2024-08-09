package org.example.beandi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author godxiaocui
 * @date 2024/7/2616:38
 */
public class TestBook {
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean-di.xml");
        book book =(book) ac.getBean("book");
        System.out.println(book);
    }
}
