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

        System.out.println("Строки короче средней:");
        boolean found = false;

        for (int i = 0; i < strings.length; i++) {
            int length = strings[i].length();
            if (length < average) {
                System.out.printf("%d. \"%s\" (длина: %d)%n",
                    i + 1, strings[i], length);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Таких строк нет.");
        }
    }

    public double averageLength() {
        int totalLength = 0;
        for (String str : strings) {
            totalLength += str.length();
        }
        return (double) totalLength / strings.length;
    }
}
