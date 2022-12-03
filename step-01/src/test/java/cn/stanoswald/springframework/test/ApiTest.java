package cn.stanoswald.springframework.test;

import cn.stanoswald.springframework.BeanDefinition;
import cn.stanoswald.springframework.BeanFactory;
import cn.stanoswald.springframework.test.bean.UserService;
import org.junit.jupiter.api.Test;

public class ApiTest {

    @Test
    public void test_BeanFactory() {
        BeanFactory beanFactory = new BeanFactory();

        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}
