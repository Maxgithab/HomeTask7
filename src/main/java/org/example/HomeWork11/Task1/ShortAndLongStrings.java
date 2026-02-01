package org.example.HomeWork11.Task1;
//найти самую короткую и самую длинную строки. Вывести найденные строки и их длину.

public class ShortAndLongStrings {
    private String[] strings;

    public ShortAndLongStrings(String[] strings) {
        this.strings = strings;
    }

    public ShortAndLongStrings(RequestStrings request) {
        this(request.getStrings());
    }

    public void findAndPrint() {
        System.out.println("\nПункт 1: Самая короткая и длинная строка");
        String shortest = shortest();
        String longest = longest();
        System.out.println("Самая короткая: \"" + shortest + "\"\nЕё длина: " + shortest.length());
        System.out.println("Самая длинная: \"" + longest + "\"\nЕё длина: " + longest.length());
    }

    public String shortest() {
        String shortest = strings[0];

        for (int i = 1; i < strings.length; i++) {
            if (strings[i].length() < shortest.length()) {
                shortest = strings[i];
            }
        }
        return shortest;
    }

    public String longest() {
        String longest = strings[0];

        for (int i = 1; i < strings.length; i++) {
            if (strings[i].length() > longest.length()) {
                longest = strings[i];
            }
        }
        return longest;
    }

}

