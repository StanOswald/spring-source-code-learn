package cn.stanoswald.springframework.beans.factory;

public interface InitializingBean {

    void afterPropertiesSet() throws Exception;

}
