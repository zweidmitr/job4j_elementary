package ru.job4j.tracker;

import java.util.Comparator;

public class ItemUpComparator implements Comparator<Item> {

    @Override
    public int compare(Item item1, Item item2) {
        int res = item1.getId() - item2.getId();
        if (res == 0) {
            res = item1.getName().compareTo(item2.getName());
        }
        return res;
    }
}
