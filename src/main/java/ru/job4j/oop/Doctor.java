package ru.job4j.oop;

public class Doctor extends Profession{

private String university;

    public Doctor() {

    }

    public Doctor(String name, String surname, String education, String birthday, String university) {
        super(name, surname, education, birthday);
        this.university = university;
    }

    public Diagnosis heal(Pacient pacient) {
        return new Diagnosis();
    }

}
