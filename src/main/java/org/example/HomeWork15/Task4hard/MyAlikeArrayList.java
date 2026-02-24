package org.example.HomeWork15.Task4hard;

import java.util.Objects;

public class MyAlikeArrayList<Type> {
    private Type[] data;
    private int size;

    //конструктор без параметров - создает массив размером по умолчанию
    public MyAlikeArrayList() {
        int BASIC_CAPACITY = 10;
        this.data = (Type[]) new Object[BASIC_CAPACITY];
        this.size = 0;
    }

    //конструктор с задаваемым размером внутреннего массива
    public MyAlikeArrayList(int spaceCapacity) {
        if (spaceCapacity <= 0) {
            throw new IllegalArgumentException("Зачем неправильный размер задал, брат?");
        }
        this.data = (Type[]) new Object[spaceCapacity];
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    //    Операции(методы):
//   1. добавления элемента-----------
    public void addElements(Type items) {
        if (size >= data.length) {
            expandAdd();
        }
        data[size] = items;
        size++;

    }

    private void expandAdd() {
        final int MULTIPLY = 2;
        int newLength = data.length * MULTIPLY;
        Type[] newData = (Type[]) new Object[newLength];

        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    } // -------------------


    //   2. удаления элемента -------------------
    public Type deleteElement(int deleteIndex) {
        if (deleteIndex < 0 || deleteIndex >= size) {
            throw new IndexOutOfBoundsException("Зачем ломать пытаешься, брат? где ты индекс нашел: " + deleteIndex);
        }

        Type deleteItem = data[deleteIndex];
        for (int i = deleteIndex; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;

        return deleteItem;
    } //--------------

    //  3. получение элемента по индексу
    public Type getIndex(int takeIndex) {
        if (takeIndex < 0 || takeIndex >= size) {
            throw new IndexOutOfBoundsException("Зачем ломать пытаешься, брат? где ты индекс нашел: " + takeIndex);
        }
        return data[takeIndex];
    } //----------------

    // 4. проверка есть ли элемент в коллекции
    public boolean containElement(Type item) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(item, data[i])) {
                return true;
            }
        }
        return false;
    } //--------------

    // 5. очистка всей коллекции
    public void clearCollection() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    } //--------------
    @Override
    public String toString() {
        if (size == 0) {
            return "упс";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }



}


