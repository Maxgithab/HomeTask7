package org.example.HomeWork15.Task2;

/*
На вход поступает массив непустых строк, создайте и верните Map<String,
String> следующим образом: для каждой строки добавьте ее первый символ в
качестве ключа с последним символом в качестве значения. Пример:
pairs(["code", "bug"]) → {"b": "g", "c": "e"}
pairs(["man", "moon", "main"]) → {"m": "n"}
pairs(["man", "moon", "good", "night"]) → {"g": "d", "m": "n", "n": "t"}
* */

public class Main {
    public static void main(String[] args) {
        MapPairs pairs = new MapPairs();

        String[][] testArrays = {
            {"code", "bug"},
            {"man", "moon", "main"},
            {"man", "mood", "good", "night"},
            {"a"},
            {"a", "b", "c"},
            {"aaa", "abb", "acc"},
            {"cat", "car", "cow", "dog", "deer"},
            {"zzz"},
            {"aba", "aca", "ada"},
            {},
            {"i", "am", "java", "programmer"},
            {"hello!", "world?", "java@"},
            {"&big", "?world", "!java@"},
            {"кот", "код", "кит" , "скит"},
            {"123", "456", "789"}
        };

        for (String[] testArray : testArrays) {
            System.out.println(pairs.mapPairs(testArray));
        }
    }
}
