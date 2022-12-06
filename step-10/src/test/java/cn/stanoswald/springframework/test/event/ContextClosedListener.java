package cn.stanoswald.springframework.test.event;

import cn.stanoswald.springframework.context.ApplicationListener;
import cn.stanoswald.springframework.context.event.ContextClosedEvent;

public class ContextClosedListener implements ApplicationListener<ContextClosedEvent> {
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("关闭事件：" + this.getClass().getName());
    }
}
