package ru.job4j.oop;

public class Builder extends Engineer {
    private String location;

    public Builder() {
    }

    public Builder(String name, String surname, String education,
                   String birthday, String university, String location) {
        super(name, surname, education, birthday, university);
        this.location = location;
    }
}
