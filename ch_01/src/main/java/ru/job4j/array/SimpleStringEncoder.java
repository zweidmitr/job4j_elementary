package ru.job4j.array;

import java.util.Objects;

public class SimpleStringEncoder {
    public static String encode(String input) {
        String result = "";
        char symbol = input.charAt(0);
        int counter = 0;
        for (int i = 0; i < input.length(); i++) {
            char sym = input.charAt(i);
            if (Objects.equals(symbol, sym)) {
                counter++;
            } else {
                result += symbol;
                if (counter > 1) {
                    result += counter;
                }
                symbol = sym;
                counter = 1;
            }
        }
        result += symbol;
        if (counter > 1) {
            result += counter;
        }
        return result;
    }
}
