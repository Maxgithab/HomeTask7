package org.example.HomeWork11;

public class DoubleChars {

    private String[] strings;

    public DoubleChars(String[] strings) {
        this.strings = strings;
    }

    public DoubleChars(RequestStrings request) {
        this(request.getStrings());
    }

    public void doubleAndPrint() {
        System.out.println("\nПункт 5:Дублирование каждой буквы из начальной строки");
        for (int i = 0; i < strings.length; i++) {
            String original = strings[i];
            String doubled = doubleCharacters(original);
            System.out.printf("%d. Исходная: \"%s\"%n", i + 1, original);
            System.out.printf("   Результат: \"%s\"%n", doubled);
        }
    }

    public String doubleCharacters(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            result.append(c).append(c);
        }
        return result.toString();
    }
}