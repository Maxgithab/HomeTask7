package org.example.HomeWork11.Task1;

import java.util.Scanner;

public class RequestStrings {
    private String[] strings;
    private Scanner scanner;

    public String[] getStrings() {
        return strings;  // ← должен возвращать массив строк
    }

    public RequestStrings() {
        this.scanner = new Scanner(System.in);
        this.strings = inputFromConsole();
    }

    private String[] inputFromConsole() {
        int count = requestStringCount();
        return requestStrings(count);
    }

    private int requestStringCount() {
        while (true) {
            try {
                System.out.print("Сколько строк будет? от 3 до 10: ");
                int count = scanner.nextInt();
                scanner.nextLine();

                if (count < 3) {
                    System.out.println("Дурачок? Минимум 3 строки!");
                } else if (count > 10) {
                    System.out.println("Дурачок? Максимум 10 строк!");
                } else {
                    return count;
                }
            } catch (Exception e) {
                System.out.println("Опять за старое? Дай число от 3 до 10.");
                scanner.nextLine();
            }
        }
    }

    private String[] requestStrings(int count) {
        String[] inputStrings = new String[count];
        System.out.println("Введите " + count + " строк:");

        for (int i = 0; i < count; i++) {
            while (true) {
                System.out.print("Строка " + (i + 1) + ": ");
                String input = scanner.nextLine().trim();

                if (input.isEmpty()) {
                    System.out.println("Не пустое! По новой!");
                    continue;
                }
                inputStrings[i] = input;
                break;
            }
        }
        return inputStrings;
    }

    public void printAllStrings() {
        System.out.println("\nВходные данные");
        for (int i = 0; i < strings.length; i++) {
            System.out.printf("%d. \"%s\" (длина: %d)%n",
                i + 1, strings[i], strings[i].length());
        }
    }
}