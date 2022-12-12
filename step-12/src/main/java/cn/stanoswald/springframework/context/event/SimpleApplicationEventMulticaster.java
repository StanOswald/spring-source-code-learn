package cn.stanoswald.springframework.context.event;

import cn.stanoswald.springframework.beans.factory.BeanFactory;
import cn.stanoswald.springframework.context.ApplicationEvent;
import cn.stanoswald.springframework.context.ApplicationListener;

public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster {

    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void multicastEvent(ApplicationEvent event) {
        for (final ApplicationListener listener : getApplicationListeners(event))
            listener.onApplicationEvent(event);
    }
}
