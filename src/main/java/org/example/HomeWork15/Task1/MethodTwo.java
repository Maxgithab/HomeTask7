package org.example.HomeWork15.Task1;

import java.util.HashMap;
import java.util.Map;

public class MethodTwo {

    public Map<String, Boolean> methodTwo(String[] strings) {

        Map<String, Boolean> resultData = new HashMap<>();
        for (String word : strings) {
            if (resultData.containsKey(word)) {
                if (!resultData.get(word)) {
                    resultData.put(word, true);
                }
            } else {
                resultData.put(word, false);
            }
        }
        return resultData;
    }
}
