package ru.job4j.collection;

import java.util.HashSet;

public class UniqueTest {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String word : origin) {
            check.add(word);
        }
        for (String word : text) {
            if (!rsl == check.contains(word)) {
                return false;
            }
        }
        return true;
    }
}
