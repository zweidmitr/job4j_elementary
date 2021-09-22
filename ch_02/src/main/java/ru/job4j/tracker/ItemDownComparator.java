package ru.job4j.tracker;

import java.util.Comparator;

public class ItemDownComparator implements Comparator<Item> {
    @Override
    public int compare(Item item1, Item item2) {
        int res = item2.getId() - item1.getId();
        if (res == 0) {
            res = item2.getName().compareTo(item1.getName());
        }
        return res;
    }
}
