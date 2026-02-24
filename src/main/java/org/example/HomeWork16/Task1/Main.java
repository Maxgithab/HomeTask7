package org.example.HomeWork16.Task1;

/*
Задача 1:
На вход поступает массив строк, верните Map<String, Boolean>, где каждая отдельная
строка является ключом, и ее значение равно true, если эта строка встречается в массиве
2 или более раз. Пример:
wordMultiple(["a", "b", "a", "c", "b"]) → {"a": true, "b": true, "c": false}
wordMultiple(["c", "b", "a"]) → {"a": false, "b": false, "c": false}
wordMultiple(["c", "c", "c", "c"]) → {"c": true}
*/

import java.util.Map;

public class Main {
    public static void main(String[] args) {

        String[][] testData = {
            {"a", "b", "a", "c", "b"},
            {"c", "b", "a"},
            {"c", "c", "c", "c"},
            {"x"},
            {},
            {"a", "a", "a", "b", "b"}
        };

        MethodOne first = new MethodOne();
        MethodTwo second = new MethodTwo();

        for (String[] test : testData) {
            System.out.println("-------");

            Map<String, Boolean> result1 = first.methodOne(test);
            System.out.println("Первый " + result1);

            Map<String, Boolean> result2 = second.methodTwo(test);
            System.out.println("Второй " + result2);
        }
    }
}
