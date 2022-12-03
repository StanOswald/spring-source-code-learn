package cn.stanoswald.springframework.beans.factory.config;

import cn.stanoswald.springframework.beans.factory.BeanFactory;
import cn.stanoswald.springframework.beans.factory.HierarchicalBeanFactory;

/**
 *
 *
 *
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 * @description Configuration interface to be implemented by most bean factories. Provides
 * facilities to configure a bean factory, in addition to the bean factory
 * client methods in the {@link BeanFactory}
 * interface.
 * @date 2022/3/9
 *
 *
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

}
