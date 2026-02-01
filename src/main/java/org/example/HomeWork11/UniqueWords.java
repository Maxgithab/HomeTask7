package org.example.HomeWork11;

public class UniqueWords {
    private String[] strings;

    public UniqueWords(String[] strings) {
        this.strings = strings;
    }

    public UniqueWords(RequestStrings request) {
        this(request.getStrings());
    }



}
