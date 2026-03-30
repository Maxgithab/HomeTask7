package org.example.HomeWork20.Task3Hard;

public class Store {
    private int productCount = 0;
    private int totalProduced = 0;
    private int totalConsumed = 0;

    public synchronized void produce() {
        int MAX_CAPACITY = 3;
        while (productCount >= MAX_CAPACITY) {
            try {
                System.out.println("Товаров в магазине больше положенного, производитель ждет");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        productCount++;
        totalProduced++;
        System.out.println("(Produce) В магазине: " + productCount +
            " Всего произведено: " + totalProduced);

        notifyAll();
    }

    public synchronized void consume() {
        while (productCount <= 0) {
            try {
                System.out.println("Товаров в магазине нет, покупатель ждет");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        productCount--;
        totalConsumed++;
        System.out.println("(Consume) В магазине: " + productCount +
            " Всего куплено: " + totalConsumed);

        notifyAll();
    }
}
