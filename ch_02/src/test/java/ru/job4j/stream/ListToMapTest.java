package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ListToMapTest {

    @Test
    public void fromListToMapSize() {
        List<Student> students = List.of(
                new Student(7, "Alex"),
                new Student(5, "Dmitr"),
                new Student(6, "Var"),
                new Student(8, "Ksu"),
                new Student(10, "Zwei"),
                new Student(10, "Zwei")
        );
        ListToMap mapFromL = new ListToMap();
        int result = mapFromL.fromListToMap(students).size();
        assertThat(result, is(5));
    }

    @Test
    public void fromListToMapKey() {
        List<Student> students = List.of(
                new Student(7, "Alex"),
                new Student(5, "Dmitr"),
                new Student(6, "Var"),
                new Student(8, "Ksu"),
                new Student(10, "Zwei"),
                new Student(10, "Zwei")
        );
        ListToMap mapFromL = new ListToMap();
        boolean result = mapFromL.fromListToMap(students).containsKey("Zwei");
        assertThat(result, is(true));
    }

    @Test
    public void fromListToMapKeySt() {
        List<Student> students = new ArrayList<>();
        Student st1 = new Student(7, "Alex");
        Student st2 = new Student(9, "Zwei");
        Student st3 = new Student(8, "Dmitr");
        students.add(st1);
        students.add(st2);
        students.add(st3);
        ListToMap mapFromL = new ListToMap();
        Student result = mapFromL.fromListToMap(students).get("Dmitr");
        assertThat(result, is(st3));
    }
}