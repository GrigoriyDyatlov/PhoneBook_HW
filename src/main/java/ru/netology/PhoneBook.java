package ru.netology;

import java.util.*;

public class PhoneBook {
    private final Map<String, String> phoneBookNameKey = new TreeMap<>();
    private final Map<String, String> phoneBookNumberKey = new HashMap<>();

    public int add (String name, String number){
        if (phoneBookNameKey.get(name) != null) {
            IllegalStateException ex = new IllegalStateException("This number already added.");
            throw ex;
        } else {
            phoneBookNameKey.putIfAbsent(name, number);
            phoneBookNumberKey.putIfAbsent(number, name);
        }
        return phoneBookNameKey.size();
    }

    public String findByNumber (String number){
        if (phoneBookNumberKey.get(number) == null) {
            return "Number missing.";
        } else return phoneBookNumberKey.get(number);
    }
}
