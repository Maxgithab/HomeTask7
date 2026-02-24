package org.example.HomeWork17.Task5;

/*
* Задача 5:
Используя Supplier написать метод, который будет возвращать введенную с консоли
строку задом наперед.*/


import java.util.Scanner;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Supplier<String> reverseMethod = () -> {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Дай текст: ");
            String inputData = scanner.nextLine();
            System.out.println("Вернем всё в зад!");
          return new StringBuilder(inputData).reverse().toString();
        };

        System.out.println(reverseMethod.get());
    }
}
