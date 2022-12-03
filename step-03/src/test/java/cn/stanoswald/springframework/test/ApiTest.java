package cn.stanoswald.springframework.test;

import cn.stanoswald.springframework.beans.factory.config.BeanDefinition;
import cn.stanoswald.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.stanoswald.springframework.test.bean.UserService;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ApiTest {

    @Test
    public void test_BeanFactory() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        UserService userService = (UserService) beanFactory.getBean("userService", "stanoswald");
        userService.queryUserInfo();
    }
}
