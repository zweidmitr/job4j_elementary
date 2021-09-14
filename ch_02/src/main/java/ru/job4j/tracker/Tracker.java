package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findByName(String key) {
        int count = 0;
        Item[] arrayItem = new Item[size];
        for (int index = 0; index < size; index++) {
            Item it = items[index];
            if (it.getName() == key) {
                arrayItem[count] = it;
                count++;
            }
        }
        arrayItem = Arrays.copyOf(arrayItem, count);
        return arrayItem;
    }

    public boolean replace(int id, Item item) {
        item.setId(id);
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            items[index] = item;
        }
        return rsl;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            System.arraycopy(items, index + 1, items, index, size - index - 1);
            items[size - 1] = null;
            size--;
        }
        return rsl;
    }
}