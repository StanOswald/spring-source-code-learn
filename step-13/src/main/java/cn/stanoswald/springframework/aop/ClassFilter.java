package cn.stanoswald.springframework.aop;

public interface ClassFilter {
    boolean matches(Class<?> clazz);
}
