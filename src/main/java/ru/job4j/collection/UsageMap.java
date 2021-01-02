package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("aaman@mail.ru", "Aman Abdulaev");
        map.put("ivanov@mail.ru", "Ivanov Ivan");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(value);
        }
        for (Map.Entry<String, String> value : map.entrySet()) {
            String key = value.getKey();
            String str = value.getValue();
            System.out.println(key + " : " + str);
        }
    }
}
