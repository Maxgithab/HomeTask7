package org.example.HomeWork20.Task3Hard;
/*Задача *:
Имеются сущности Магазин, Производитель, Покупатель. Цель задачи сделать так, чтобы
производитель произвел 5 единиц продукта, а покупатель их купил. Пока производитель
не произвел продукт, покупатель не может его купить. При этом одновременно в магазине
может находиться не более 3 товаров*/

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("---- ОК ----");
    }
}
