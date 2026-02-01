package org.example.HomeWork11.Task1;

import java.util.Arrays;
import java.util.Comparator;


public class LengthSorter {
    private String[] strings;

    public LengthSorter(String[] strings) {
        this.strings = strings;
    }

    public LengthSorter(RequestStrings request) {
        this(request.getStrings());
    }

    public void sortAndPrint() {
        System.out.println("\nПункт 2: Упорядочить и вывести в порядке возрастания длины");
        String[] sorted = sortLengthStrings();
        for (int i = 0; i < sorted.length; i++) {
            System.out.printf("%d. \"%s\" (длина: %d) %n",
                i + 1,
                sorted[i],
                sorted[i].length());
        }
    }

    public String[] sortLengthStrings() {
        String[] copy = Arrays.copyOf(strings, strings.length);
        Arrays.sort(copy, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });
        return copy;

    }
}
