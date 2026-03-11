package org.example.HomeWork20.Task1;

/*Задача 1:
Пользователь вводит с клавиатуры значение в массив. После чего запускаются два
потока. Первый поток находит максимум в массиве, второй — минимум. Результаты
вычислений возвращаются в метод main().
*/

import java.util.Scanner;

public class Main {

    private static int[] array;
    private static int maxResult;
    private static int minResult;

    public static int[] getArray() {
        return array;
    }

    public static void setMaxResult(int valueMax) {
        maxResult = valueMax;
    }

    public static void setMinResult(int valueMin) {
        minResult = valueMin;
    }

    private static int[] readArray() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Брат, дай простые числа, через пробел (можно эти 10 -5 20 0 15):");
        String line = scanner.nextLine();

        String[] cutter = line.split(" ");
        int[] array = new int[cutter.length];

        for (int i = 0; i < cutter.length; i++) {
            array[i] = Integer.parseInt(cutter[i]);
        }
        return array;
    }

    public static void main(String[] args) {
        array = readArray();


        MaxFinder maxSearch = new MaxFinder();
        MinFinder minSearch = new MinFinder();

        Thread maxThread = new Thread(maxSearch);
        Thread minThread = new Thread(minSearch);

        maxThread.start();
        minThread.start();

        try {
            maxThread.join();
            minThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Максимум в ряду: " + maxResult);
        System.out.println("Минимум в ряду: " + minResult);


    }
}



