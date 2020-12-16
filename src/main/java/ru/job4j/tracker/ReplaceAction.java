package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "=== Edit Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        boolean rsl = tracker.replace(id, item);
        if (rsl) {
            System.out.println("The Item is edit.");
        } else {
            System.out.println("The Item is not edit, wrong id.");
        }
        return true;
    }
}
