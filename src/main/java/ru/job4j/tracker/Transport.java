package ru.job4j.tracker;

public interface Transport {
    void drive();

    void getPassengers(int passenger);

    double getFuel(int sumGas);
}
