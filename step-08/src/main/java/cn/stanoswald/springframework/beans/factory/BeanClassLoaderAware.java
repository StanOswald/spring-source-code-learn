package cn.stanoswald.springframework.beans.factory;

public interface BeanClassLoaderAware extends Aware {

    void setBeanClassLoader(ClassLoader classLoader);

}
