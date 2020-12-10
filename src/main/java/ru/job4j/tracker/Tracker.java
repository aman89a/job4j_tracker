package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

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

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        /* Находим индекс */
        int index = indexOf(id);
        /* Если индекс найден возвращаем item, иначе null */
        return index != -1 ? items[index] : null;
    }
    
    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key){
            Item[] itemsWithoutNull = new Item[items.length];
            int temp = 0;
        for (int i = 0; i < this.size; i++) {
            if (items[i].getName().equals(key)) {
                itemsWithoutNull[temp] = items[i];
                temp++;
            }
        }
            return Arrays.copyOf(itemsWithoutNull, temp);
    }
    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (-1 != index) {
            items[index] = item;
            items[index].setId(id);
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        if (-1 != index) {
            int start = index + 1;
            int length = size - 1;
            items[index] = null;
            System.arraycopy(items, start, items, index, length);
            items[size - 1] = null;
            size--;
            return true;
        }
        return false;
    }
}
