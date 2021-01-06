package ru.job4j.tracker;

import java.util.Comparator;

public class SortItemByAsc implements Comparator<Item> {
    @Override
    public int compare(Item firstItem, Item secondItem) {
        return firstItem.compareTo(secondItem);
    }
}
