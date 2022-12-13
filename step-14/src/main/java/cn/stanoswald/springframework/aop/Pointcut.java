package cn.stanoswald.springframework.aop;

public interface Pointcut {
    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();
}
