package cn.stanoswald.springframework.context;

import cn.stanoswald.springframework.beans.factory.HierarchicalBeanFactory;
import cn.stanoswald.springframework.beans.factory.ListableBeanFactory;
import cn.stanoswald.springframework.core.io.ResourceLoader;

public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {
}
