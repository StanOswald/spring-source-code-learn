package cn.stanoswald.springframework.test;

import cn.stanoswald.springframework.context.support.ClassPathXmlApplicationContext;
import cn.stanoswald.springframework.test.bean.*;
import cn.stanoswald.springframework.test.event.CustomEvent;
import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

public class ApiTest {

    @Test
    public void test_event() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");

        applicationContext.publishEvent(new CustomEvent(applicationContext, 101918273645L, "成功了！"));

        applicationContext.registerShutdownHook();

        applicationContext.publishEvent(new CustomEvent(applicationContext, 101918273645L, "成功了！"));
    }
}
