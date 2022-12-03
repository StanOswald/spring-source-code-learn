package cn.stanoswald.springframework.test;

import cn.hutool.core.io.IoUtil;
import cn.stanoswald.springframework.beans.PropertyValue;
import cn.stanoswald.springframework.beans.PropertyValues;
import cn.stanoswald.springframework.beans.factory.config.BeanDefinition;
import cn.stanoswald.springframework.beans.factory.config.BeanReference;
import cn.stanoswald.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.stanoswald.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import cn.stanoswald.springframework.context.support.ClassPathXmlApplicationContext;
import cn.stanoswald.springframework.core.io.DefaultResourceLoader;
import cn.stanoswald.springframework.core.io.Resource;
import cn.stanoswald.springframework.test.bean.UserDao;
import cn.stanoswald.springframework.test.bean.UserService;
import cn.stanoswald.springframework.test.common.MyBeanFactoryPostProcessor;
import cn.stanoswald.springframework.test.common.MyBeanPostProcessor;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class ApiTest {
    @Test
    public void test_BeanFactoryPostProcessorAndBeanPostProcessor() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        MyBeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
        beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);

        MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
        beanFactory.addBeanPostProcessor(beanPostProcessor);

        UserService userService = beanFactory.getBean("userService", UserService.class);
        System.out.println(userService.queryUserInfo());
    }

    @Test
    public void test_xml() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:springPostProcessor.xml");

        UserService userService = applicationContext.getBean("userService", UserService.class);
        System.out.println(userService.queryUserInfo());
    }
}
