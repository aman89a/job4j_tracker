package ru.job4j.oop;

public class Programmer extends Engineer {
    private String location;

    public Programmer() {
    }

    public Programmer(String name, String surname,
                      String education, String birthday,
                      String university, String location) {
        super(name, surname, education, birthday, university);
        this.location = location;
    }
}
