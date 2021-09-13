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
        int count = 0;
        Item[] arrayItem = new Item[size];
        for (int index = 0; index < size; index++) {
            Item it = items[index];
            if (it.getName() != null) {
                arrayItem[count] = it;
                count++;
            }
        }
        arrayItem = Arrays.copyOf(arrayItem, count);
        return arrayItem;

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
        add(item);
        int index = indexOf(id);
        Item it = items[index];
        items[index] = item;
        items[index].setId(id);
        items[size - 1] = it;
        items[size - 1].setId(item.getId());

        return index != -1 ? true : false;
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
}