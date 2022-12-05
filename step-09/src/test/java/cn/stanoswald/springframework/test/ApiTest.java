package cn.stanoswald.springframework.test;

import cn.stanoswald.springframework.context.support.ClassPathXmlApplicationContext;
import cn.stanoswald.springframework.test.bean.*;
import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

public class ApiTest {

    @Test
    public void test_prototype() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        UserService userService01 = applicationContext.getBean("userService", UserService.class);
        UserService userService02 = applicationContext.getBean("userService", UserService.class);

        System.out.println(userService01.queryUserInfo());
        System.out.println(userService02.queryUserInfo());

        System.out.println(userService01 + "十六进制哈希值：" + Integer.toHexString(userService01.hashCode()));
        System.out.println(userService02 + "十六进制哈希值：" + Integer.toHexString(userService02.hashCode()));

        System.out.println(ClassLayout.parseInstance(userService01).toPrintable());
        System.out.println(ClassLayout.parseInstance(userService02).toPrintable());
    }

    @Test
    public void test_factory_bean() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        Foo foo1 = applicationContext.getBean("fooFactory", Foo.class);
        Foo foo2 = applicationContext.getBean("fooFactory", Foo.class);
        System.out.println(applicationContext.getBean("fooFactory").hashCode());

        System.out.println(foo1.hashCode() + " " + foo1.getBar());
        System.out.println(foo2.hashCode() + " " + foo2.getBar());
        System.out.println(applicationContext.getBean("foo", Foo.class).hashCode() + " " + applicationContext.getBean("foo", Foo.class).getBar());
        System.out.println(applicationContext.getBean("foo", Foo.class).hashCode() + " " + applicationContext.getBean("foo", Foo.class).getBar());
    }
}
