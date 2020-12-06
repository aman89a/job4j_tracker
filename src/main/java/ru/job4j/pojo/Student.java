package ru.job4j.pojo;

import java.time.LocalDate;

public class Student {
    private String fio;
    private String group;
    private LocalDate created = LocalDate.now();

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }
}
