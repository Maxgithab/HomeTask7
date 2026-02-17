package org.example.HomeWork15.Task4hard;

/*Задача *:
Представим, что в Java нет коллекции типа ArrayList. Создать свой класс, симулирующий
работу класса динамической коллекции - т.е. создать свою кастомную коллекцию. В
основе коллекции будет массив. Кастомная коллекция должна хранить элементы разных
классов(т.е. это generic).
Предусмотреть операции(методы):
1. добавления элемента
2. удаления элемента
3. получение элемента по индексу
4. проверка есть ли элемент в коллекции
5. очистка всей коллекции
Предусмотреть конструктор без параметров - создает массив размером
по умолчанию. Предусмотреть конструктор с задаваемым размером внутреннего
массива. Предусмотреть возможность автоматического расширения коллекции при
добавлении элемента в том случае, когда коллекция уже заполнена.
*/

public class Main {
    public static void main(String[] args) {
        testWithStrings(); //строки
        testWithIntegers(); // числа
        testWithCustomCapacity(); //конструктор
    }

    private static void testWithStrings() {
        MyAlikeArrayList<String> stringList = new MyAlikeArrayList<>();

        System.out.println("--- Тест 1: Строки ---");
        System.out.println("Создали пустой список: " + stringList);
        System.out.println("Размер: " + stringList.getSize());

        System.out.println("\nДобавляем элементы:");
        stringList.addElements("Один");
        stringList.addElements("Два");
        stringList.addElements("Три");
        System.out.println("После добавления: " + stringList);
        System.out.println("Размер: " + stringList.getSize());

        System.out.println("\nЭлемент с индексом 1: " + stringList.getIndex(1));

        System.out.println("Содержит 'Два'? " + stringList.containElement("Два"));
        System.out.println("Содержит 'ДваДва'? " + stringList.containElement("ДваДва"));

        System.out.println("\nУдаляем элемент с индексом 0");
        String removed = stringList.deleteElement(0);
        System.out.println("Удалён: " + removed);
        System.out.println("После удаления: " + stringList);

        System.out.println("\nОчищаем коллекцию");
        stringList.clearCollection();
        System.out.println("После очистки: " + stringList);
        System.out.println("Размер: " + stringList.getSize());

        System.out.println();
    }

    private static void testWithIntegers() {
        System.out.println("--- Тест 2: Числа ---");

        MyAlikeArrayList<Integer> numberList = new MyAlikeArrayList<>();

        for (int i = 1; i <= 5; i++) {
            numberList.addElements(i * 7);
        }

        System.out.println("Список: " + numberList);
        System.out.println("Размер: " + numberList.getSize());

        System.out.println("Содержит 30? " + numberList.containElement(30));
        System.out.println("Содержит 35? " + numberList.containElement(35));

        System.out.println("Элемент с индексом 2: " + numberList.getIndex(2));

        System.out.println("Удаляем индекс 1: " + numberList.deleteElement(1));
        System.out.println("После удаления: " + numberList);

        System.out.println();
    }

    private static void testWithCustomCapacity() {
        System.out.println("--- Тест 3: Конструктор ---");

        // Создаём с маленьким размером
        MyAlikeArrayList<String> smallList = new MyAlikeArrayList<>(2);

        System.out.println("Создали список с capacity = 2");

        // Добавляем элементы
        smallList.addElements("A");
        System.out.println("Добавили A: " + smallList);

        smallList.addElements("B");
        System.out.println("Добавили B: " + smallList);

        System.out.println("Размер: " + smallList.getSize());
        System.out.println("Массив заполнен, сейчас должно произойти расширение...");

        smallList.addElements("C");
        System.out.println("Добавили C (после расширения): " + smallList);
        System.out.println("Размер (после расширения): " + smallList.getSize());

        smallList.addElements("D");
        smallList.addElements("E");
        smallList.addElements("F");
        smallList.addElements("G");
        smallList.addElements("H");

        System.out.println("Добавили ещё несколько: " + smallList);
        System.out.println("Размер: " + smallList.getSize());
    }

}
