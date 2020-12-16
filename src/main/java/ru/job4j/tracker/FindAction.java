package ru.job4j.tracker;

public class FindAction implements UserAction {
    private final Output out;

    public FindAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "find by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find by name. ====");
        String name = input.askStr("Enter name: ");
        Item[] items = tracker.findByName(name);
        if (items.length != 0) {
            for (Item item : items) {
                out.println(item.toString());
            }
        } else {
            out.println("No coincidences.");
        }
        return true;
    }
}
