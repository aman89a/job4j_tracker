package ru.job4j.paterns.creational.singleton;

public class ProgramLogger {
    private static ProgramLogger programLogger;
    private static String logFile = "This is log file.";

    public static synchronized ProgramLogger getProgramLogger() {
        if (programLogger == null) {
            programLogger = new ProgramLogger();
        }
        return programLogger;
    }

    private ProgramLogger() {

    }

    public void addLogs (String log) {
        logFile += System.lineSeparator() + log;
    }

    public void getLog () {
        System.out.println(logFile);
    }
}
