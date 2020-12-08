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

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
    public Item[] findAll() {
        Item[] itemsWithoutNull = new Item[items.length];
        int size = 0;
        for (Item name : items) {
            if (name != null) {
                itemsWithoutNull[size] = name;
                size++;
            }
        }
        itemsWithoutNull = Arrays.copyOf(itemsWithoutNull, size);
        return itemsWithoutNull;
    }

    public Item[] findByName(String key){
            Item[] itemsWithoutNull = new Item[items.length];
            int size = 0;
        for (Item name : items) {
            if (name != null && name.getName().equals(key)) {
                itemsWithoutNull[size] = name;
                size++;
            }
        }
            itemsWithoutNull = Arrays.copyOf(itemsWithoutNull, size);
            return itemsWithoutNull;
    }
}
