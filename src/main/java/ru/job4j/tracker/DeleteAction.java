package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "=== DeleteAction ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id: ");
        boolean rsl = tracker.delete(id);
        if (rsl) {
            System.out.println("The Item is delete.");
        } else {
            System.out.println("The Item is not delete, wrong id.");
        }
        return true;
    }
}
