package org.example.HomeWork20.Task3Hard;

public class Producer implements Runnable {
    private final Store store;

    public Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        int produced = 0;
        int TARGET = 5;

        while (produced < TARGET) {
            store.produce();
            produced++;

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Производителем завершена работа");
    }
}
