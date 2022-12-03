package cn.stanoswald.springframework.beans.factory.config;

import cn.stanoswald.springframework.beans.BeansException;

public interface BeanPostProcessor {

    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;

}
