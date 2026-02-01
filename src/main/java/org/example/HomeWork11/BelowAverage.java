package org.example.HomeWork11;

public class BelowAverage {
    private String[] strings;

    public BelowAverage(String[] strings) {
        this.strings = strings;
    }

    public BelowAverage(RequestStrings request) {
        this(request.getStrings());
    }

    public void findBelowAverageAndPrint() {
        System.out.println("\nПункт 3: Вывести строки, которые меньше средней, и их длину");
        double average = averageLength();
        System.out.printf("Средняя длина строк: %.2f %n", average);
    }

    public double averageLength() {
        int totalLength = 0;
        for (String str : strings) {
            totalLength += str.length();
        }
        return (double) totalLength / strings.length;
    }
}
