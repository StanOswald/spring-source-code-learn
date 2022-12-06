package cn.stanoswald.springframework.test.bean;

import cn.stanoswald.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class ProxyBeanFactory implements FactoryBean<IUserDao> {
    @Override
    public IUserDao getObject() {
        InvocationHandler handler = ((proxy, method, args) -> {
            Map<String, String> dataMap = new HashMap<>();

            dataMap.put("10001", "stanoswald");
            dataMap.put("10002", "test123");
            dataMap.put("10003", "test234");

            return "你被代理了 " + method.getName() + ": " + dataMap.get(args[0].toString());
        });

        return (IUserDao) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class[]{IUserDao.class}, handler);
    }

    @Override
    public Class<?> getObjectType() {
        return IUserDao.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
