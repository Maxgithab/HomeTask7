package org.example.HomeWork16.Task1;

import java.util.HashMap;
import java.util.Map;

public class MethodOne {

    public Map<String, Boolean> methodOne(String[] strings) {

        Map<String, Integer> countData = new HashMap<>();
        for (String word : strings) {
            countData.put(word, countData.getOrDefault(word, 0) + 1);
        }

        Map<String, Boolean> resultData = new HashMap<>();
        for (String word : strings) {
            resultData.put(word, countData.get(word) >= 2);
        }
        return resultData;
    }
}
