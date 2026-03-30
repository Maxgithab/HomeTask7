/*Задача 2:
Сортировка массива цифр в нескольких потоках различными алгоритмами:
 сортировка вставками;
 сортировка выбором;
 сортировка пузырьком.
Каждый вид сортировки должен запускаться в отдельном потоке. После вывести
результат отсортированных массивов в консоль.*/

package org.example.HomeWork20.Task2;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int[] generalArray = createArray();
        SortResult[] results = new SortResult[3];

        Thread thread1 = new Thread(() -> {
            long startTime = System.currentTimeMillis();
            int[] sorted = SortAlgorithms.bubbleSort(generalArray);
            long endTime = System.currentTimeMillis();
            results[0] = new SortResult("bubble", sorted, endTime - startTime);
        });

        Thread thread2 = new Thread(() -> {
            long startTime = System.currentTimeMillis();
            int[] sorted = SortAlgorithms.insertionSort(generalArray);
            long endTime = System.currentTimeMillis();
            results[1] = new SortResult("insertion", sorted, endTime - startTime);
        });

        Thread thread3 = new Thread(() -> {
            long startTime = System.currentTimeMillis();
            int[] sorted = SortAlgorithms.selectionSort(generalArray);
            long endTime = System.currentTimeMillis();
            results[2] = new SortResult("selection", sorted, endTime - startTime);
        });

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (SortResult r : results) {
            System.out.println(r.name + " (" + r.time + " мс)");
        }

    }

    private static int[] createArray() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Каких размеров массив будем сортировать? Больше 100 000  не вводить, иначе долго");
        int sizeMassive = scanner.nextInt();

        int[] array = new int[sizeMassive];
        for (int i = 0; i < sizeMassive; i++) {
            array[i] = random.nextInt(100);
        }
        return array;

    }
}
