package org.example.HomeWork18;

/*Задача 1:
Создать коллекцию класса ArrayList наполнить ее элементами типа Integer. С помощью
Stream'ов:
        - Удалить дубликаты
- Оставить только четные элементы
- Вывести сумму оставшихся элементов в стриме*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 4, 4, 5, 6, 6, 7, 8));

        System.out.println("На входе: " + numbers);
        System.out.println("После фильтрации: ");

        int stream = numbers.stream()
                .distinct()
                .filter(n -> n % 2 == 0)
                .peek(n -> System.out.print(n + " "))
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("\nСумма: " + stream);
    }
}
