package org.example.HomeWork17.Task4;

import java.util.function.Consumer;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        double exchaneRate = 3.4;

        Consumer<String> bynToUsd = string -> {
            String[] text = string.split(" ");
            String amountTextCurrency = text[0];

            double amountBynCurrency = Double.parseDouble(amountTextCurrency);
            double usd = amountBynCurrency / exchaneRate;

            System.out.printf("Сумма в USD: %.2f$%n", usd);

        };

        String price = "100 BYN";
        bynToUsd.accept(price);
    }
}
