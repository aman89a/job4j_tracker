package ru.job4j.tracker;

import java.util.Comparator;

public class SortItemByDesc implements Comparator<Item> {
    @Override
    public int compare(Item secondItem, Item firstItem) {
        return firstItem.getName().compareTo(secondItem.getName());
    }
}
