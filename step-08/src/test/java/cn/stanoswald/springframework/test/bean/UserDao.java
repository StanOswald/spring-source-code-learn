package cn.stanoswald.springframework.test.bean;

import java.util.HashMap;
import java.util.Map;

public class UserDao {

    private static final Map<String, String> dataMap = new HashMap<>();

    public void initData() {
        System.out.println("执行init-method");
        dataMap.put("10001", "stanoswald");
        dataMap.put("10002", "test123");
        dataMap.put("10003", "test234");
    }

    public void destroyData() {
        System.out.println("执行destroy-method");
        dataMap.clear();
    }

    public String queryUserName(String uId) {
        return dataMap.get(uId);
    }
}
