package cn.stanoswald.springframework.test;

import cn.stanoswald.springframework.aop.AdvisedSupport;
import cn.stanoswald.springframework.aop.MethodMatcher;
import cn.stanoswald.springframework.aop.TargetSource;
import cn.stanoswald.springframework.aop.aspect.AspectJExpressionPointcut;
import cn.stanoswald.springframework.aop.framework.Cglib2AopProxy;
import cn.stanoswald.springframework.aop.framework.JdkDynamicAopProxy;
import cn.stanoswald.springframework.aop.framework.ReflectiveMethodInvocation;
import cn.stanoswald.springframework.test.bean.IUserService;
import cn.stanoswald.springframework.test.bean.UserService;
import cn.stanoswald.springframework.test.bean.UserServiceInterceptor;
import org.aopalliance.intercept.MethodInterceptor;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ApiTest {

    @Test
    public void test_proxy_class() {
        IUserService userService = (IUserService) Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(),
                new Class[]{IUserService.class},
                (proxy, method, args) -> "你被代理了！"
        );

        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }

    @Test
    public void test_proxy_method() {
        Object targetObj = new UserService();

        IUserService proxy = (IUserService) Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(),
                targetObj.getClass().getInterfaces(),
                new InvocationHandler() {
                    MethodMatcher methodMatcher = new AspectJExpressionPointcut("execution(* cn.stanoswald.springframework.test.bean.IUserService.*(..))");

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (methodMatcher.matches(method, targetObj.getClass())) {
                            MethodInterceptor methodInterceptor = invocation -> {
                                long start = System.currentTimeMillis();
                                try {
                                    return invocation.proceed();
                                } finally {
                                    System.out.println("监控 - Begin By AOP");
                                    System.out.println("方法名称：" + invocation.getMethod());
                                    System.out.println("方法耗时：" + (System.currentTimeMillis() - start) + "ms");
                                    System.out.println("监控 - End\r\n");
                                }
                            };
                            return methodInterceptor.invoke(new ReflectiveMethodInvocation(targetObj, method, args));
                        }
                        return method.invoke(targetObj, args);
                    }
                });
        String result = proxy.queryUserInfo();
        System.out.println("测试结果：" + result);
    }

    @Test
    public void test_aop() throws NoSuchMethodException {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut("execution(* cn.stanoswald.springframework.test.bean.IUserService.*(..))");
        Class<UserService> clazz = UserService.class;
        Method method = clazz.getDeclaredMethod("queryUserInfo");

        System.out.println(pointcut.matches(clazz));
        System.out.println(pointcut.matches(method, clazz));
    }

    @Test
    public void test_dynamic() {
        // 目标对象
        IUserService userService = new UserService();
        // 组装代理信息
        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setTargetSource(new TargetSource(userService));
        advisedSupport.setMethodInterceptor(new UserServiceInterceptor());
        advisedSupport.setMethodMatcher(new AspectJExpressionPointcut("execution(* cn.stanoswald.springframework.test.bean.IUserService.*(..))"));

        // 代理对象(JdkDynamicAopProxy)
        IUserService proxy_jdk = (IUserService) new JdkDynamicAopProxy(advisedSupport).getProxy();
        // 测试调用
        System.out.println("测试结果：" + proxy_jdk.queryUserInfo());

        // 代理对象(Cglib2AopProxy)
        IUserService proxy_cglib = (IUserService) new Cglib2AopProxy(advisedSupport).getProxy();
        // 测试调用
        System.out.println("测试结果：" + proxy_cglib.register("花花"));
    }

}
