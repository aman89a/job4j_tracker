package ru.job4j.poliformizm;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println("поезд передвигается по рельсам");
    }
}
