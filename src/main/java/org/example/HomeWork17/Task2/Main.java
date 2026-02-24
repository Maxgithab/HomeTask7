package org.example.HomeWork17.Task2;

/*
* Задача 2:
Используя Predicate среди массива чисел вывести только те, которые являются
положительными.*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(-5, 10, 0, 3, -2, 7, -1, 8, -9, 4);
        System.out.println("До преобразований: " + numbers);

        Predicate<Integer> positiveNub = n -> n > 0;

        List<Integer> positiveNumbers = filter(numbers, positiveNub);

        System.out.println("После преобразований: " + positiveNumbers);

    }

    private static List<Integer> filter(List<Integer> list, Predicate<Integer> predicate) {
        List<Integer> filterResult = new ArrayList<>();
        for (Integer number : list) {
            if (predicate.test(number)) {
                filterResult.add(number);
            }
        }
        return filterResult;
    }
}
