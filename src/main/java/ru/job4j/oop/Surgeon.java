package ru.job4j.oop;

public class Surgeon extends Doctor {
    private String location;

    public Surgeon(String location) {
    }

    public Surgeon(String name, String surname, String education,
                   String birthday, String university, String location) {
        super(name, surname, education, birthday, university);
        this.location = location;
    }
}
