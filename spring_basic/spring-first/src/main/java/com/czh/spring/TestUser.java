package com.czh.spring;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author godxiaocui
 * @date 2024/7/1217:06
 */
public class TestUser {

    private static final String BEAN_XML = "bean.xml";

    private Logger logger = LoggerFactory.getLogger(TestUser.class);

    @Test
    public void test() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        User user = (User) ac.getBean("user");
        user.sayHello();

        logger.info("user: {}", user);
    }
}
