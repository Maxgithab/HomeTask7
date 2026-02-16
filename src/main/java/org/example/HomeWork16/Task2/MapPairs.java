package org.example.HomeWork16.Task2;

import java.util.HashMap;
import java.util.Map;

public class MapPairs {

    public Map<String, String> mapPairs(String[] strings) {

        Map<String, String> result = new HashMap<>();

        for (String word : strings) {
            if (!word.isEmpty()) {
                String first = String.valueOf(word.charAt(0));
                String last = String.valueOf(word.charAt(word.length() - 1));

                result.put(first, last);
            }
        }
        return result;
    }
}
