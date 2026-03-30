package org.example.HomeWork18.Task2;

/* Задача *:
Создать набор данных в формате id-name, сохраненный в Map. Необходимо отобрать из
этого набора только те данные, id которых попадает в числовой диапазон 1/2/5/8/9/13.
Среди отобранных значений отобрать только те, которые имеют нечетное количество
букв в имени. После чего вернуть список List имен, записанных буквами задом наперед.*/


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> userData = new HashMap<>();
        userData.put(1, "Айван");
        userData.put(2, "Оулегий");
        userData.put(5, "Алиэкспрессей");
        userData.put(8, "Йана");
        userData.put(9, "Думитрий");
        userData.put(10, "Марийа");
        userData.put(13, "Артьём");

        UserDataSorting sorting = new UserDataSorting();
        List<String> result = sorting.userFilter(userData);

        System.out.println("Имеем по итогу:");
        result.forEach(System.out::println);
    }
}
