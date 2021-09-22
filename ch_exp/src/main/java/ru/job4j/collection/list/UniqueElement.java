package ru.job4j.collection.list;

import java.util.List;

public class UniqueElement {
    public static boolean checkList(List<String> list, String str) {
        if (list.indexOf(str) == -1) {
            return false;
        }
        return list.indexOf(str) == list.lastIndexOf(str);
    }
}
