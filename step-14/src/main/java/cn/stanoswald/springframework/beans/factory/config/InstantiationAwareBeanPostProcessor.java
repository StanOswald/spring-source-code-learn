package cn.stanoswald.springframework.beans.factory.config;

import cn.stanoswald.springframework.beans.BeansException;
import cn.stanoswald.springframework.beans.PropertyValues;

public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor {

    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;

    PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName) throws BeansException;

}
