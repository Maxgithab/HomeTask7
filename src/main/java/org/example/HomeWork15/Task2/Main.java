package org.example.HomeWork15.Task2;

/*
*Задача 2:
Создать класс, который будет хранить в себе коллекцию с названиями животных.
Реализовать методы удаления и добавления животных по следующим правилам:
добавляется всегда в начало коллекции, а удаляется всегда из конца. Показать работу
объекта этого класса в main методе другого класса.
* */

public class Main {
    public static void main(String[] args) {
        AnimalCollection animalCollection = new AnimalCollection();

        System.out.println("Добавление: ");
        animalCollection.addAnimal("Кот");
        animalCollection.showCollection();

        animalCollection.addAnimal("Собака");
        animalCollection.showCollection();

        animalCollection.addAnimal("Попугай");
        animalCollection.addAnimal("Хомяк");
        animalCollection.showCollection();

        animalCollection.addAnimal("Петрович");

        System.out.println("Удаление: ");
        animalCollection.removeAnimal();
        animalCollection.showCollection();

        System.out.println("--Удаляем до Петровича!--");
        while (!animalCollection.isEmptyCollection()) {
            animalCollection.removeAnimal();
            animalCollection.showCollection();
        }
        System.out.println("И Петровича не пожалели!");
    }
}
