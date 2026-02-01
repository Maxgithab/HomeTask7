package org.example.HomeWork11;

import java.util.HashSet;
import java.util.Set;

public class UniqueWords {
    private String[] strings;

    public UniqueWords(String[] strings) {
        this.strings = strings;
    }

    public UniqueWords(RequestStrings request) {
        this(request.getStrings());
    }

    public void findUniqueAndPrint() {
        System.out.println("\nПункт 4: Первое слово из различных символов");
        String result = findFirstUnique();
        if (result != null) {
            System.out.println(result + " - первое найденное");
        } else {
            System.out.println("Слов с различными символами не найдено");
        }
    }

    public String findFirstUnique() {
        for (String line : strings) {
            String[] words = splitWords(line);
            for (String word : words) {
                if (hasAllUniuqe(word)) {
                    return word;
                }
            }
        }
        return null;
    }

    private String[] splitWords(String str) {
        return str.trim().split("\\s+");
    }

    private boolean hasAllUniuqe(String word) {
        if (word.isEmpty()) return false;

        Set<Character> characters = new HashSet<>();

        for (char c : word.toCharArray()) {
            if (characters.contains(c)) {
                return false;
            }
            characters.add(c);
        }
        return true;
    }
}
