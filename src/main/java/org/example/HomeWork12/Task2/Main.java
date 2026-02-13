package org.example.HomeWork12.Task2;

/*Задача *:
Программа на вход получает произвольный текст. В этом тексте может быть номер
документа(один или несколько), емейл и номер телефона. Номер документа в формате:
xxxx-xxxx-xx, где x - это любая цифра; номер телефона в формате: +(xx)xxxxxxx. Документ
может содержать не всю информацию, т.е. например, может не содержать номер
телефона, или другое. Необходимо найти эту информацию и вывести в консоль в
формате:
email: teachmeskills@gmail.com
document number: 1423-1512-51
и т.д
* */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FinderText find = new FinderText();

        String testText = """
            1423-1512-51 email: ivanov@mail.com Тел.+(37)1234567
            документ: 1424-1513-52 Email: petrov@gmail.com Без телефона
            +(38)7654321  email: info@company.org
            Мои документы: 1111-2222-33 и 4444-5555-66.
            Пишите на email@test.com или звоните +(77)1234567.
            Уважаемый клиент!\s
            Ваш заказ №1234-5678-90 готов.
            Контакты: support@shop.com, +(55)1112233.
            Счет №9876-5432-10 прилагается. email: teachmeskills@gmail.com
            document number: 1423-1512-51
            не документ: 12-34-56-78
            документ: 1234-5678-90
            не телефон: +37(123)4567
            телефон: +(37)1234567
            не email: user@com
            email: user@domain.com
            name.lastname@subdomain.company.co.uk
            8-800-555-35-35
           \s""";
        find.search(testText);

        scanner.close();

    }
}
