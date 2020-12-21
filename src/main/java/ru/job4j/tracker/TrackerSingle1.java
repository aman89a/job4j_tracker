package ru.job4j.tracker;

public enum TrackerSingle1 {
    INSTANCE;

    private final Tracker tracker = new Tracker();

    public Tracker getTracker() {
        return tracker;
    }
}
