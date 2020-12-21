package ru.job4j.tracker;

public class TrackerSingle3 {
    private static final TrackerSingle3 INSTANCE = new TrackerSingle3();

    private final Tracker tracker = new Tracker();

    public Tracker getTracker() {
        return tracker;
    }
}
