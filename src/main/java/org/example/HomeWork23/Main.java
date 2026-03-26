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

public class Main {
    public static void main(String[] args) {
        parseWithSax();
    }

    private static void parseWithSax() {
        try {
            SaxParserService saxParserService = new SaxParserService();
            String fileOutput = saxParserService.parseAndSade("sonnet.xml");
            System.out.println("Вроде создали " + fileOutput);

        } catch (Exception e) {
            System.out.println("Упс..." + e.getMessage());
            e.printStackTrace();
        }
    }
}


