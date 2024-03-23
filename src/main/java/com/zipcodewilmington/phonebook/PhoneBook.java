package com.zipcodewilmington.phonebook;

import java.util.*;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phoneBook;

// CONSTRUCTORS //

    public PhoneBook() {
        this.phoneBook = new LinkedHashMap<>();
    }

    public PhoneBook(Map<String, List<String>> phoneBook) {
        this.phoneBook = phoneBook;
    }

// METHODS //

    public void add(String name, String phoneNumber) {
        phoneBook.put(name, Collections.singletonList(phoneNumber));
    }

    public void addAll(String name, String... phoneNumbers) {
        phoneBook.put(name, List.of(phoneNumbers));
    }

    public void remove(String name) {
        phoneBook.remove(name);
    }

    public Boolean hasEntry(String name) {
        return phoneBook.containsKey(name);
    }

    public Boolean hasEntry(String name, String phoneNumber) {
        List<String> phoneNumbers = phoneBook.get(name);
        return phoneNumbers != null && phoneNumbers.contains(phoneNumber);
    }

    public List<String> lookup(String name) {
        return phoneBook.get(name);
    }

    public String reverseLookup(String phoneNumber) {
        for (Map.Entry<String, List<String>> keyVal : phoneBook.entrySet()) {
            List<String> phoneNumbers = keyVal.getValue();
            if (phoneNumbers.contains(phoneNumber)) {
                return keyVal.getKey();
            }
        }
        return null;
    }

    public List<String> getAllContactNames() {
        List<String> contactNames = new ArrayList<>();

        for (String name : phoneBook.keySet()) {
            contactNames.add(name);
        }
        return contactNames;
    }

    public Map<String, List<String>> getMap() {
        return phoneBook;
    }

}
