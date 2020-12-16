package ru.job4j.tracker;

public class ReadeItemsAction implements UserAction {
    private final Output out;

    public ReadeItemsAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "find all Items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Fint all Items.====");
        for (Item item : tracker.findAll()) {
            out.println(item.toString());
        }
        return true;
    }
}
