package ru.job4j.array;

public class SimpleStringEncoder {
    public static String encode(String input) {
        StringBuilder result = new StringBuilder();
        char symbol = input.charAt(0);
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (symbol == input.charAt(i)) {
                count++;
            } else {
                result.append(symbol);
                if (count > 1) {
                    result.append(count);
                }
                symbol = input.charAt(i);
                count = 1;
            }
        }
        result.append(symbol);
        if (count > 1) {
            result.append(count);
        }
        return result.toString();
    }
}
