package ru.job4j.collection;

import java.util.List;

public class RemoveIf {
    public static List<String> sortList(List<String> list) {
        list.removeIf(i -> i.length() < 5);
        return list;
    }
}
