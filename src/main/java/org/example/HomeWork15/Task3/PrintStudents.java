package org.example.HomeWork15.Task3;

import java.util.List;

public class PrintStudents {
    public static void printAll(List<Student> students) {
        for (Student s : students) {
            System.out.println("   " + s);
        }
    }
}
