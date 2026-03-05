package org.example.HomeWork18.Task2;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class UserDataSorting {
    Set<Integer> ID = Set.of(1, 2, 5, 8, 9, 13);

    public List<String> userFilter(Map<Integer, String> users) {
        return users.entrySet().stream()
                .filter(integerStringEntry -> ID.contains(integerStringEntry.getKey()))
                .filter(integerStringEntry -> integerStringEntry.getValue().length() % 2 != 0)
                .map(integerStringEntry -> new StringBuilder(integerStringEntry.getValue()).reverse().toString())
                .collect(Collectors.toList());
    }


}
