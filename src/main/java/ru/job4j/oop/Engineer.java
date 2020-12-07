package ru.job4j.oop;

public class Engineer extends Profession{
    private String university;

    public Engineer() {
    }

    public Engineer(String name, String surname, String education, String birthday, String university) {
        super(name, surname, education, birthday);
        this.university = university;
    }

    public Project develop(Pacient pacient) {
        return new Project();
    }
}
