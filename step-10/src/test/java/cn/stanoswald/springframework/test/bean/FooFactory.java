package cn.stanoswald.springframework.test.bean;

import cn.stanoswald.springframework.beans.factory.FactoryBean;

public class FooFactory implements FactoryBean<Foo> {
    @Override
    public Foo getObject() {
        Foo foo = new Foo();
        foo.setBar("from foo factory");
        return foo;
    }

    @Override
    public Class<?> getObjectType() {
        return Foo.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
