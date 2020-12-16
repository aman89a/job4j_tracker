package ru.job4j.tracker;

public class FindAction implements UserAction {
    @Override
    public String name() {
        return "=== Find By Name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        Item[] items = tracker.findByName(name);
        if (items.length != 0) {
            for (Item item : items) {
                System.out.println(item.toString());
            }
        } else {
            System.out.println("No coincidences.");
        }
        return true;
    }
}
