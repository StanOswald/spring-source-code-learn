package cn.stanoswald.springframework.context.event;

import cn.stanoswald.springframework.context.ApplicationEvent;
import cn.stanoswald.springframework.context.ApplicationListener;

public interface ApplicationEventMulticaster {

    void addApplicationListener(ApplicationListener<?> listener);

    void removeApplicationListener(ApplicationListener<?> listener);

    void multicastEvent(ApplicationEvent event);

}
