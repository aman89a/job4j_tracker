package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Ivan Ivanov");
        student.setGroup("It-A2020");
        student.getCreated();

        System.out.println("FIO: " + student.getFio()+ System.lineSeparator() + "Group: " + student.getGroup() + System.lineSeparator() + "Created date: " + student.getCreated());
    }
}
