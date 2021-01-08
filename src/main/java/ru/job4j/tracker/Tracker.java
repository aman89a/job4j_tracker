package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private List<Item> items = new ArrayList<>();
    private int ids = 1;

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public Item findById(int id) {
        for (Item item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
    
    public List<Item> findAll() {
        return items;
    }

    public List<Item> findByName(String key) {
        List<Item> namesList = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                namesList.add(item);
                return namesList;
            }
        }
        return null;
    }

    public boolean replace(int id, Item item) {
        if (items.contains(findById(id))) {
            items.set(indexOf(id), item);
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        return items.remove(findById(id));
    }

    @Override
    public String toString() {
        return "Tracker{"
               + "items=" + items
               + ", ids=" + ids
               + '}';
    }
}
