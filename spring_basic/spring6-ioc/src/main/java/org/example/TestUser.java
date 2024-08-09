package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author godxiaocui
 * @date 2024/7/2616:17
 */
public class TestUser {

    public static void main(String[] args) {
        ApplicationContext apx = new ClassPathXmlApplicationContext("bean.xml");
        //id
        User user=(User)apx.getBean("user");
        System.out.println(user);
    // 类型
        User user2=(User)apx.getBean(User.class);
        System.out.println(user2);

        // 根据id和类型
        User user3=(User)apx.getBean("user",User.class);
        System.out.println(user3);
    }
}
