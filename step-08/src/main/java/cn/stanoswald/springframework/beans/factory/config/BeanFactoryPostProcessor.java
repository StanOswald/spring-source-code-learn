package cn.stanoswald.springframework.beans.factory.config;

import cn.stanoswald.springframework.beans.BeansException;
import cn.stanoswald.springframework.beans.factory.ConfigurableListableBeanFactory;

public interface BeanFactoryPostProcessor {

    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;

}
