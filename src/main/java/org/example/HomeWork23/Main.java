package org.example.HomeWork23;
/*Задача 1:
Написать программу для парсинга xml документа. Необходимо распарсить xml документ и
содержимое тегов line записать в другой документ. Название файла для записи должно
состоять из значений тегов и имеет вид: <firstName>_<lastName>_<title>.txt

Задача *:
Дополнительно реализовать следующий функционал: если с консоли введено значение
1 - распарсить документ с помощью SAX, если с консоли введено значение
2 - распарсить документ с помощью DOM.
*/

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean check = true;

        while (check) {
            menu();
            String choose = scanner.nextLine().trim();

            switch (choose) {
                case "1":
                    parseWithSax();
                    break;
                case "2":
                    parseWithDom();
                    break;
                case "0":
                    check = false;
                    System.out.println("Хватит это терпеть!");
                    break;
                default:
                    System.out.println("Не, ну ты серьезно?");
            }
        }
    }

    private static void menu() {
        System.out.println("Чаво желаем?");
        System.out.println("1 - парсим через Sax");
        System.out.println("2 - парсим через Dom");
        System.out.println("0 - ничего не парсим, ибо лень");
        System.out.println("-----------");
    }

    private static void parseWithSax() {
        System.out.println("SAX");
        try {
            SaxParserService saxParserService = new SaxParserService();
            String fileOutput = saxParserService.parseAndSade("sonnet.xml");
            System.out.println("Вроде создали " + fileOutput);

        } catch (Exception e) {
            System.out.println("Упс..." + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void parseWithDom() {
        System.out.println("DOM");
        try {
            DomParserService domParserService = new DomParserService();
            String fileOutput = domParserService.parseAndSade("sonnet.xml");
            System.out.println("Вроде создали " + fileOutput);

        } catch (
            Exception e) {
            System.out.println("Упс..." + e.getMessage());
            e.printStackTrace();
        }
    }
}


