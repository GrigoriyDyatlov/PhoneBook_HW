package ru.netology;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private final Map<String, String> phoneBook = new HashMap<>();

    public int add (String name, String number){
        if (phoneBook.get(name) != null) {
            IllegalStateException ex = new IllegalStateException("This number already added.");
            throw ex;
        } else phoneBook.putIfAbsent(name, number);
        return phoneBook.size();
    }
}
