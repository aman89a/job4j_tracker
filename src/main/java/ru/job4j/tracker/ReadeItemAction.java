package ru.job4j.tracker;

public class ReadeItemAction implements UserAction {
    @Override
    public String name() {
        return "=== Find Item By Id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id: ");
        Item value = tracker.findById(id);
        if (value == null){
            System.out.println("Item is null.");
        } else {
            System.out.println(value.toString());
        }
        return true;
    }
}
