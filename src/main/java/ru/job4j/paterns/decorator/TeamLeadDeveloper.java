package ru.job4j.paterns.decorator;

public class TeamLeadDeveloper extends DeveloperDecorator {

    public TeamLeadDeveloper(Developer developer) {
        super(developer);
    }

    public String sendWeekReport() {
        return "Send week report to customer.";
    }

    @Override
    public String makeJob() {
        return super.makeJob() + sendWeekReport();
    }
}
