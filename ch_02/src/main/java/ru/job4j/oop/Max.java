package ru.job4j.oop;

public class Max {

    public static int max(int one, int two) {
        return one > two ? one : two;
    }

    public static int max(int one, int two, int three) {
        return max(three, max(one, two));
    }

    public static int max(int one, int two, int three, int four) {
        return max(max(three, four), max(one, two));
    }

}