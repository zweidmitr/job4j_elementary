package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

public class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Petr", "Arsentev", "534872", "Bruansk"));
        ArrayList<Person> persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname(), is("Arsentev"));
    }

    @Test
    public void whenEmptyFind() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("ein", "zwei", "drei", "vier"));
        ArrayList<Person> persons = phones.find("funf");
        assertTrue(persons.isEmpty());
    }
}