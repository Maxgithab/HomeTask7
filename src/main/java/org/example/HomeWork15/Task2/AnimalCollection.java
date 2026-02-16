package org.example.HomeWork15.Task2;

import java.util.ArrayDeque;
import java.util.Deque;

public class AnimalCollection {
    private Deque<String> animals;

    public AnimalCollection() {
        animals = new ArrayDeque<>();
    }

    public void addAnimal(String animal) {
        animals.addFirst(animal);
        System.out.println("Добавлен: " + animal);
    }

    public String removeAnimal() {

        if (animals.isEmpty()) {
            System.out.println("Тут животных нетъ");
            return null;
        }

        String removedAnimal = animals.removeLast();
        System.out.println("Удален: " + removedAnimal);
        return removedAnimal;
    }

    public void showCollection() {
        System.out.println("Текущая коллекция: " + animals);
    }

    public boolean isEmptyCollection() {
        return animals.isEmpty();
    }

}
