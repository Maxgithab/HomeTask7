package org.example.HomeWork13.Task2;

public class Final {
    public static void main(String[] args) {
        try {
            System.out.println("Работает до прерывания");
            System.exit(0);
            System.out.println("1. Оно не должно появиться");
        }
        finally {
            System.out.println("2. Оно не должно появиться");
        }
    }
}
