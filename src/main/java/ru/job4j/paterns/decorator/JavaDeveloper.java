package ru.job4j.paterns.decorator;

public class JavaDeveloper implements Developer {
    @Override
    public String makeJob() {
        return "Write java code.";
    }
}
