package org.example.HomeWork11;

public class RequestStrings {
    // 1 часть
    private String str1;
    private String str2;
    private String str3;
    private String[] strings;

    public RequestStrings() {
        str1 = "Первая первая первая";
        str2 = "Вторая вторая";
        str3 = "Третья";

        strings = new String[3];
        strings[0] = str1;
        strings[1] = str2;
        strings[2] = str3;
    }

    public String[] getStrings() {
        return strings;
    }

    public void printAllStrings() {
        System.out.println("Входные данные");
        for (int i = 0; i < strings.length; i++) {
            System.out.printf("%d. \"%s\" (длина: %d)%n", i + 1, strings[i], strings[i].length());
        }
    }
}