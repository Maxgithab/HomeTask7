package org.example.HomeWork20.Task1;

public class MinFinder implements Runnable {

    @Override
    public void run() {
        int[] array = Main.getArray();
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            System.out.println("Поиск MIN :" + array[i]);
            if (array[i] < min) {
                min = array[i];
                System.out.println("Сейчас MIN - это " + min);
            }
        }

        Main.setMinResult(min);
        System.out.println("Поток поиска минимума завершил работу");

    }
}
