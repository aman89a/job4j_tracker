package ru.job4j.tracker;

import ru.job4j.oop.Pacient;

import java.time.format.DateTimeFormatter;

public class StartUI {

    public static void main(String[] args) {

        Tracker tracker = new Tracker();
        tracker.add(new Item("Develop a plan."));
        tracker.add(new Item("Take a plan."));
        tracker.add(new Item("Send a plan."));
        System.out.println(tracker.replace(2, new Item("bug")));
        System.out.println(tracker.delete(2));
        //Find by Id
        System.out.println();
        System.out.println(tracker.findById(1).getName());
        System.out.println(tracker.findById(3).getName());
        //Find by All
        System.out.println();
        Item[] items = tracker.findAll();
        for (Item value : items) {
            System.out.println(value.getName());
        }
        //Find by Name
        System.out.println();
        for(Item item:tracker.findByName("Develop a plan.")){
            System.out.println(item.getName());
        }
    }
}
