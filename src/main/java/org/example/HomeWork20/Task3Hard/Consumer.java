package org.example.HomeWork20.Task3Hard;

public class Consumer implements Runnable{
    private final Store store;

    public Consumer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        int consumed = 0;
        int TARGET = 5;

        while (consumed < TARGET) {
            store.consume();
            consumed++;

            try {
                Thread.sleep(750);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Покупатель купил весь товар");
    }
}
