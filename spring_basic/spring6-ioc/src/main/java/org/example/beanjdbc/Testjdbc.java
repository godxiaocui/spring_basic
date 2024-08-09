package org.example.beanjdbc;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @author godxiaocui
 * @date 2024/7/3013:29
 */
public class Testjdbc {

    @Test
    public void testJdbc() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean-jdbc.xml");
        DruidDataSource dataSource = ac.getBean(DruidDataSource.class);
        System.out.println(dataSource.getUrl());
    }
}
