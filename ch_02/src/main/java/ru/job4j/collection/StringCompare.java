package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int temp = 0;
        int min = o1.length() < o2.length() ? o1.length() : o2.length();
        //   int max = o1.length() > o2.length() ? o1.length() : o2.length();

        for (int i = 0; i < min; i++) {
            char a = o1.charAt(i);
            char b = o2.charAt(i);
            temp = Character.compare(a, b);
            if (temp < 0) {
                return -1;
            } else if (temp > 0) {
                return 1;
            }
        }
        if (o1.length() == o2.length()) {
            return temp;
        }

        temp = o1.length() < o2.length() ? -1 : 1;
        return temp;
    }

    public static void main(String[] args) {
        String one = "Patrova";
        String two = "Petrov";
        StringCompare compare = new StringCompare();
        int res = compare.compare(one, two);
        System.out.println(res);
    }
}
