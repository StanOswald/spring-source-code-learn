package cn.stanoswald.springframework.test;

import cn.stanoswald.springframework.beans.PropertyValue;
import cn.stanoswald.springframework.beans.PropertyValues;
import cn.stanoswald.springframework.beans.factory.config.BeanDefinition;
import cn.stanoswald.springframework.beans.factory.config.BeanReference;
import cn.stanoswald.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.stanoswald.springframework.test.bean.UserDao;
import cn.stanoswald.springframework.test.bean.UserService;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ApiTest {

    @Test
    public void test_BeanFactory() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValues(new PropertyValue("uId", "10001"));
        propertyValues.addPropertyValues(new PropertyValue("userDao", new BeanReference("userDao")));

        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}
