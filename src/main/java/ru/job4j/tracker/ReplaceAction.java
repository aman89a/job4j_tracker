package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "edit";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Replace Items. ====");
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        boolean rsl = tracker.replace(id, item);
        if (rsl) {
            out.println("The Item is edit.");
        } else {
            out.println("The Item is not edit, wrong id.");
        }
        return true;
    }
}
