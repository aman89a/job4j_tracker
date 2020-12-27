package ru.job4j.paterns.decorator;

public class Task {
    public static void main(String[] args) {
        Developer developer = new TeamLeadDeveloper(new SeniorJavaDeveloper(new JavaDeveloper()));
        System.out.println(developer.makeJob());
    }
}
