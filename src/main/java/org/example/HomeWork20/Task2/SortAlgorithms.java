package org.example.HomeWork20.Task2;

import java.util.Arrays;

public class SortAlgorithms {

    public static int[] insertionSort(int[] source) {
        // Сортировка вставками
        int[] arr = Arrays.copyOf(source, source.length);

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    // Сортировка выбором
    public static int[] selectionSort(int[] source) {
        int[] arr = Arrays.copyOf(source, source.length);

        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) minIdx = j;
            }
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
        return arr;
    }

    // Сортировка пузырьком
    public static int[] bubbleSort(int[] source) {
        int[] arr = Arrays.copyOf(source, source.length);

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}
