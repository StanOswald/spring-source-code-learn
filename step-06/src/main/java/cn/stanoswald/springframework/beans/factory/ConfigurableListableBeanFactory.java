package cn.stanoswald.springframework.beans.factory;

import cn.stanoswald.springframework.beans.BeansException;
import cn.stanoswald.springframework.beans.factory.config.AutowireCapableBeanFactory;
import cn.stanoswald.springframework.beans.factory.config.BeanDefinition;
import cn.stanoswald.springframework.beans.factory.config.ConfigurableBeanFactory;

public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;

}