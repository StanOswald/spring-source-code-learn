package cn.stanoswald.springframework.test.bean;

import java.util.HashMap;
import java.util.Map;

public class UserDao {

    private static final Map<String, String> dataMap = new HashMap<>();

    static {
        dataMap.put("10001", "stanoswald");
        dataMap.put("10002", "test123");
        dataMap.put("10003", "test234");
    }

    public String queryUsername(String uId) {
        return dataMap.get(uId);
    }
}
