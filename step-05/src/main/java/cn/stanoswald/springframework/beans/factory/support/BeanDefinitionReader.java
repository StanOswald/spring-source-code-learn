package cn.stanoswald.springframework.beans.factory.support;

import cn.stanoswald.springframework.beans.BeansException;
import cn.stanoswald.springframework.core.io.Resource;
import cn.stanoswald.springframework.core.io.ResourceLoader;

/**
 *
 *
 *
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 * @description Simple interface for bean definition readers.
 * @date 2022/3/9
 *
 *
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;

}
