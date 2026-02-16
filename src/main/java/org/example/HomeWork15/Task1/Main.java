package org.example.HomeWork15.Task1;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/*
* Задача 1:
Пользователь вводит набор чисел в виде одной строки с клавиатуры. Например: "1, 2, 3,
4, 4, 5". Избавиться от повторяющихся элементов в строке. Вывести результат на экран.
При решении использовать коллекции.*/

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Дай числа");

        //5, 10, 15, 20, 25 | 100, 200, 300 | 1, 1, 2, 3, 5, 8, 13 | 42, 42, 99, 3, 7, 8, 10 | 7, 14, 21, 28, 35, 42 | 1000, 500, 250, 125 | 2, 4, 6, 8, 10, 12, 14, 16, 18, 20 | 9, 18, 27, 36, 45, 54, 63, 72, 81, 90 | 11, 22, 33, 44, 55, 66, 77, 88, 99 | 123, 456, 789, 123, 456, 789
        String input = scanner.nextLine();

        String[] inputData = input.split("\\D+");

        Set<String> uniqueNumb = new LinkedHashSet<>();

        for (String item : inputData) {
            if (!item.isEmpty()) {
                uniqueNumb.add(item);
            }
        }
        System.out.println("Было: " + input);
        System.out.println("Стало " + uniqueNumb);
    }
}
