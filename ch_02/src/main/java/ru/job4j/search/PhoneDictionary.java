package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person pers : persons) {
            if (pers.getSurname().contains(key) || pers.getPhone() .contains(key)
                    || pers.getAddress().contains(key)
                    || pers.getName().contains(key)) {
                result.add(pers);
                break;
            }
        }
        return result;
    }
}
