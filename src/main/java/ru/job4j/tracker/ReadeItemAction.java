package ru.job4j.tracker;

public class ReadeItemAction implements UserAction {
    private final Output out;

    public ReadeItemAction(Output out) {
        this.out= out;
    }

    @Override
    public String name() {
        return "find by id.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find by id. ====");
        int id = input.askInt("Enter id: ");
        Item value = tracker.findById(id);
        if (value == null){
            out.println("Item is null.");
        } else {
            out.println(value.toString());
        }
        return true;
    }
}
