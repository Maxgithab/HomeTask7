package org.example.HomeWork15.Task3;

import java.util.Iterator;
import java.util.List;

public class StudentTerminate {

    public void processStudents(List<Student> students) {
        Iterator<Student> iterator = students.iterator();

        while (iterator.hasNext()) {
            Student student = iterator.next();
            double averageGrade = student.averageGrade();

            if (averageGrade < 3.0) {
                System.out.println(student.getName() + ", вон c пляжа!");
                iterator.remove();
            } else {
                student.upCourse();
                System.out.println(student.getName() + ", милости прошу к нашему шалашу.");
            }

        }

    }

    public void printListStudents(List<Student> students, int course) {
        System.out.println("Курс: " + course);

        boolean foundSomeone = false;

        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println("Студент: " + student.getName() + ", группа " + student.getGroup());
                foundSomeone = true;
            }
        }
        if (!foundSomeone) {
            System.out.println("Студент на " + course + " курсе не обнаружен");
        }
    }

}
