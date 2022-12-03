package cn.stanoswald.springframework.beans.factory;

public interface DisposableBean {

    void destroy() throws Exception;

}
