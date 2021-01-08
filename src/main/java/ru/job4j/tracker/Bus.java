package ru.job4j.tracker;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("Автобус едет.");
    }

    @Override
    public void getPassengers(int passenger) {
        System.out.println(passenger);
    }

    @Override
    public double getFuel(int sumGas) {
        return sumGas * 45.5;
    }
}
