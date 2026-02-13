package org.example.HomeWork13.Task1;

/*
Задача 1:
Создать класс, в котором будет статический метод. Этот метод принимает на вход три
параметра: login, password, confirmPassword. Все поля имеют тип данных String. Длина
login должна быть меньше 20 символов и не должен содержать пробелы. Если login не
соответствует этим требованиям, необходимо выбросить WrongLoginException. Длина
password должна быть меньше 20 символов, не должен содержать пробелом и должен
содержать хотя бы одну цифру. Также password и confirmPassword должны быть равны.
Если password не соответствует этим требованиям, необходимо выбросить
WrongPasswordException. WrongPasswordException и WrongLoginException -
пользовательские классы исключения с двумя конструкторами – один по умолчанию,
второй принимает сообщение исключения и передает его в конструктор класса Exception.
Метод возвращает true, если значения верны, false в противном случае.
 */

public class Main {
    public static void main(String[] args) {

        boolean result1 = Validation.validate("user123", "pass123word", "pass123word");
        boolean result2 = Validation.validate("оченьдлинныйлогинбольше20", "pass1", "pass1");
        boolean result3 = Validation.validate("user name", "pass1", "pass1");
        boolean result4 = Validation.validate("user", "password", "password");
        boolean result5 = Validation.validate("user", "pass123", "pass456");
        boolean result6 = Validation.validate("user", "pass 123", "pass 123");
        boolean result7 = Validation.validate("ghyt", "", "");


        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);
        System.out.println(result6);
        System.out.println(result7);
    }
}

