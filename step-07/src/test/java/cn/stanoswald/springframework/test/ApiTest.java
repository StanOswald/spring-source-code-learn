package cn.stanoswald.springframework.test;

import cn.stanoswald.springframework.context.support.ClassPathXmlApplicationContext;
import cn.stanoswald.springframework.test.bean.UserService;
import org.junit.Test;

public class ApiTest {

    @Test
    public void test_xml() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        UserService userService = applicationContext.getBean("userService", UserService.class);
        System.out.println(userService.queryUserInfo());
    }
}
