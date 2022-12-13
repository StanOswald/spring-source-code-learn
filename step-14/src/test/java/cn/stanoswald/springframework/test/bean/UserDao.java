package cn.stanoswald.springframework.test.bean;

import cn.stanoswald.springframework.sterotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserDao {

    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "Stanoswald,Fuzhou");
        hashMap.put("10002", "Popcorn,Shanghai");
    }

    public String queryUsername(String uId) {
        return hashMap.get(uId);
    }
}
