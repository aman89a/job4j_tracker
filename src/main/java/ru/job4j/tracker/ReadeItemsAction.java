package ru.job4j.tracker;

public class ReadeItemsAction implements UserAction {
    @Override
    public String name() {
        return "=== Read All Items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        for (Item item : tracker.findAll()) {
            System.out.println(item.toString());
        }
        return true;
    }
}
