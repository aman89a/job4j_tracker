package ru.job4j.tracker;

import ru.job4j.poliformizm.Train;

public class StartUI {
    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }
    public static void readeItems(Input input, Tracker tracker){
        System.out.println("=== Show all items ====");
        for (Item item : tracker.findAll()) {
            System.out.println(item.toString());
        }
    }
    public static void readeItem(Input input, Tracker tracker){
        System.out.println("=== Find item by Id ====");
        int id = input.askInt("Enter id: ");
        Item value = tracker.findById(id);
        if (value == null){
            System.out.println("Item is null.");
        } else {
            System.out.println(value.toString());
        }
    }
    public static void findByName(Input input, Tracker tracker){
        System.out.println("=== Find items by name ====");
        String name = input.askStr("Enter name: ");
        Item[] items = tracker.findByName(name);
        if (items.length != 0) {
            for (Item item : items) {
                System.out.println(item.toString());
            }
        } else {
            System.out.println("No coincidences.");
        }
    }
    public static void replaceItem(Input input, Tracker tracker){
        System.out.println("=== Edit item ====");
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        boolean rsl = tracker.replace(id, item);
        if (rsl) {
            System.out.println("The Item is edit.");
        } else {
            System.out.println("The Item is not edit, wrong id.");
        }
    }
    public static void deleteItem(Input input, Tracker tracker){
        System.out.println("=== Delete item ====");
        int id = input.askInt("Enter id: ");
        boolean rsl = tracker.delete(id);
        if (rsl) {
            System.out.println("The Item is delete.");
        } else {
            System.out.println("The Item is not delete, wrong id.");
        }
    }
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.readeItems(input, tracker);
            } else if (select == 2) {
                StartUI.replaceItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.readeItem(input, tracker);
            } else if (select == 5) {
                StartUI.findByName(input, tracker);
            } else if (select == 6) {
                run = false;
            }
        }
    }
    private void showMenu() {
        System.out.println("0. Add new Item\n" +
                "1. Show all items\n" +
                "2. Edit item\n" +
                "3. Delete item\n" +
                "4. Find item by Id\n" +
                "5. Find items by name\n" +
                "6. Exit Program");
    }
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
