package org.example.HomeWork11;

/*
1. Ввести 3 строки с консоли, найти самую короткую и самую длинную строки. Вывести найденные строки и их длину.
2. Ввести 3 строки с консоли. Упорядочить и вывести строки в порядке возрастания значений их длины.
3. Ввести 3 строки с консоли. Вывести на консоль те строки, длина которых меньше средней, а также их длину.
4. Ввести 3 строки с консоли. Найти слово, состоящее только из различных символов. Если таких слов несколько, найти первое из них.
5. Вывести на консоль новую строку, которой задублирована каждая буква из начальной строки. Например, "Hello" -> "HHeelllloo".
*/
public class Main {
    public static void main(String[] args) {
        RequestStrings request = new RequestStrings();
        request.printAllStrings();

        ShortAndLongStrings task1 = new ShortAndLongStrings(request);
        task1.findAndPrint();

        LengthSorter task2 = new LengthSorter(request);
        task2.sortAndPrint();

        BelowAverage task3 = new BelowAverage(request);
        task3.findBelowAverageAndPrint();

        UniqueWords task4 = new UniqueWords(request);
        task4.findUniqueAndPrint();

        DoubleChars task5 = new DoubleChars(request);
        task5.doubleAndPrint();

    }
}
