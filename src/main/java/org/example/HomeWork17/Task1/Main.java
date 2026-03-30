package org.example.HomeWork17.Task1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/*Задача 1:
Пользователь вводит в консоль дату своего рождения. Программа должна вернуть дату,
когда пользователю исполнится 100 лет. Использовать Date/Time API.*/

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Жду дату рождения");
        String inputDate = scanner.nextLine().trim();

        scanner.close();

        LocalDate birthDate = tryDate(inputDate);

        if (birthDate == null) {
            System.out.println("Миша, зачем ввел некорректную дату, давай по новой!");
            return;
        }

        LocalDate oneHundredYear = birthDate.plusYears(100);
        System.out.println(oneHundredYear);


    }

    private static LocalDate tryDate(String input) {
        DateTimeFormatter[] formatters = {
            DateTimeFormatter.ofPattern("dd.MM.yyyy"),
            DateTimeFormatter.ofPattern("yyyy-MM-dd"),
            DateTimeFormatter.ofPattern("MM/dd/yyyy"),
            DateTimeFormatter.ofPattern("dd MM yyyy"),
            DateTimeFormatter.ofPattern("dd-MM-yyyy"),
            DateTimeFormatter.ofPattern("dd/MM/yyyy")
        };
        for (DateTimeFormatter formatter : formatters) {
            try {
                return LocalDate.parse(input, formatter);
            } catch (DateTimeParseException ignored) {
            }
        }
        return null;
    }
}
