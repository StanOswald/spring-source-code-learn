package cn.stanoswald.springframework.beans.factory;

import cn.stanoswald.springframework.beans.BeansException;

public interface BeanFactory {
    Object getBean(String name);

    Object getBean(String name, Object... args) throws BeansException;
}
