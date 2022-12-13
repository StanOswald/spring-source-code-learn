package cn.stanoswald.springframework.context.event;

import cn.stanoswald.springframework.context.ApplicationContext;
import cn.stanoswald.springframework.context.ApplicationEvent;

public class ApplicationContextEvent extends ApplicationEvent {

    public ApplicationContextEvent(Object source) {
        super(source);
    }

    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }

}
