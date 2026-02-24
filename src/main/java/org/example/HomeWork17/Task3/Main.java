package org.example.HomeWork17.Task3;

/*
*Задача 3:
Используя Function реализовать лямбду, которая будет принимать в себя строку в
формате “*сумма* BYN”(через пробел, вместо *сумма* вставить любое значение), а
возвращать сумму, переведенную сразу в доллары.
*/

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        double exchaneRate = 3.4;

        Function<String, Double> bynToUsd = string -> {
            String[] text = string.split(" ");
            String amountTextCurrency = text[0];
            double amountBynCurrency = Double.parseDouble(amountTextCurrency);
            double amountUsdCurrency = amountBynCurrency / exchaneRate;
            return amountUsdCurrency;
        };
    }
}
