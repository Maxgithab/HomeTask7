package org.example.HomeWork12.Task1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Abbreviation {

    public void findAbbreviations() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Дай текст:");
            String text = scanner.nextLine();

            if (text.trim().isEmpty()) {
                System.out.println("не то!");
                return;
            }
            findAndPrintAbbreviations(text);
        } finally {
            scanner.close();
        }
    }

    public void findAndPrintAbbreviations(String text) {
        Pattern pattern = Pattern.compile("\\b[A-ZА-ЯеЁ]{2,6}\\b");
        Matcher matcher = pattern.matcher(text);
        System.out.println(matcher);

        while (matcher.find()) {
            String abbreviation = matcher.group();
            System.out.println("- " + abbreviation);
        }
    }
}