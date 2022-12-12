package cn.stanoswald.springframework.beans.factory;

public interface FactoryBean<T> {

    T getObject() throws Exception;

    Class<?> getObjectType();

    /**
     * @return 由FactoryBean创建bean实例的作用域是否为singleton
     */
    boolean isSingleton();

}
