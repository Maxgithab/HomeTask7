package org.example.HomeWork15.Task3;

/*
Создать класс Student, содержащий следующие характеристики – имя, группа, курс,
оценки по предметам. Создать коллекцию, содержащую объекты класса Student.
Написать метод, который удаляет студентов со средним баллом <3. Если средний
балл>=3, студент переводится на следующий курс. Дополнительно написать метод
printStudents(List<Student> students, int course), который получает список студентов и
номер курса. А также печатает на консоль имена тех студентов из списка, которые
обучаются на данном курсе.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student("Вася", "Java-11", 1, Arrays.asList(5, 4, 5, 4)));
        students.add(new Student("Петя", "Java-11", 1, Arrays.asList(3, 2, 3, 2)));
        students.add(new Student("Манька", "Java-12", 2, Arrays.asList(5, 5, 4, 5)));
        students.add(new Student("Ржавый", "Java-12", 2, Arrays.asList(2, 3, 2, 3)));
        students.add(new Student("Дюша", "Java-13", 3, Arrays.asList(4, 4, 4, 4)));
        students.add(new Student("Нася", "Java-13", 3, Arrays.asList(5, 5, 5, 5)));
        students.add(new Student("Димас", "Java-14", 4, Arrays.asList(3, 3, 3, 3)));
        students.add(new Student("Святослав", "Java-14", 4, Arrays.asList(2, 2, 3, 2)));

        System.out.println("---Список---");
        PrintStudents.printAll(students);

        System.out.println("\n---Что думает деканат---");
        StudentTerminate terminate = new StudentTerminate();
        terminate.processStudents(students);

        System.out.println("\n---Кто остался---");
        PrintStudents.printAll(students);

        System.out.println("\n---Уточненный список оставшихся---");
        terminate.printListStudents(students, 1);
        terminate.printListStudents(students, 2);
        terminate.printListStudents(students, 3);
        terminate.printListStudents(students, 4);
        terminate.printListStudents(students, 5);


    }
}
