package ru.job4j.tracker;

public class TrackerSingle4 {

    private Tracker tracker;

    private TrackerSingle4() {
    }

    public Tracker getTracker() {
        return tracker;
    }

    public static Tracker getInstance() {
        return Holder.INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }

    private static final class Holder {
        private static final Tracker INSTANCE = new Tracker();
    }

    public static void main(String[] args) {
        Tracker tracker = TrackerSingle4.getInstance();
    }
}
