package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item it = new Item();
        LocalDateTime tekTime = it.getTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String currentTime = tekTime.format(formatter);
        System.out.println("На часах сейчас: " + currentTime);

        System.out.println();
        Item dateItem = new Item(2140, "Date Item");
        System.out.println(dateItem);

    }
}
