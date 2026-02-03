package org.example.HomeWork12.Task1;

/* Задача 1:
Вывести в консоль из строки которую пользователь вводит с клавиатуры все
аббревиатуры. Аббревиатурой будем считать слово от 2 до 6 символов, состоящее
только из прописных букв, без чисел.
* */

public class Main {
    public static void main(String[] args) {
        Abbreviation find = new Abbreviation();
        find.findAbbreviations();
    }
}
