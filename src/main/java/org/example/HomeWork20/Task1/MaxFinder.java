package org.example.HomeWork20.Task1;

public class MaxFinder implements Runnable {

    @Override
    public void run() {
        int[] array = Main.getArray();
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            System.out.println("Поиск MAX :" + array[i]);
            if (array[i] > max) {
                max = array[i];
                System.out.println("Сейчас MAX - это " + max);
            }
        }

        Main.setMaxResult(max);
        System.out.println("Поток поиска максимума завершил работу");

    }
}
