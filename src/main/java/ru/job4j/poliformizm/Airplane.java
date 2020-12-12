package ru.job4j.poliformizm;

public class Airplane implements Vehicle{
    @Override
    public void move() {
        System.out.println("самолет летает по воздуху");
    }
}
