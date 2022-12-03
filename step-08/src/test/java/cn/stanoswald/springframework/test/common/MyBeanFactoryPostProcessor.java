package cn.stanoswald.springframework.test.common;

import cn.stanoswald.springframework.beans.BeansException;
import cn.stanoswald.springframework.beans.PropertyValue;
import cn.stanoswald.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.stanoswald.springframework.beans.factory.config.BeanDefinition;
import cn.stanoswald.springframework.beans.factory.config.BeanFactoryPostProcessor;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue("company", "改为：字节跳动"));
    }
}
