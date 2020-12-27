package ru.job4j.paterns.decorator;

public class SeniorJavaDeveloper extends DeveloperDecorator {


    public SeniorJavaDeveloper(Developer developer) {
        super(developer);
    }

    public String madeCodeReview(){
        return "Make Code review.";
    }

    @Override
    public String makeJob() {
        return super.makeJob() + madeCodeReview();
    }
}
