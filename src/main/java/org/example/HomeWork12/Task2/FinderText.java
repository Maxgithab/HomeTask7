package org.example.HomeWork12.Task2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FinderText {

    public void search(String text) {
        System.out.println("Результат поиска");
        findAndPrint("\\d{4}-\\d{4}-\\d{2}", text, "document number"); // xxxx-xxxx-xx
        findAndPrint("[\\w.%+-]+@[\\w.-]+\\.[A-Za-z]{2,}", text, "email"); // skills@gmail.com
        findAndPrint("\\+\\(\\d{2}\\)\\d{7}", text, "phone"); // +(xx)xxxxxxx
    }

    private void findAndPrint(String regex, String text, String logo) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(logo + ": " + matcher.group());
        }
    }
}
