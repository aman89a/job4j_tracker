package ru.job4j.oop;

public class Dentist extends Doctor {
    private String location;

    public Dentist() {
    }

    public Dentist(String name, String surname, String education, String birthday, String university, String location) {
        super(name, surname, education, birthday, university);
        this.location = location;
    }
}
