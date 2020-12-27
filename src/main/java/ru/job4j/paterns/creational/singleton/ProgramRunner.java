package ru.job4j.paterns.creational.singleton;

public class ProgramRunner {

    public static void main(String[] args) {
        ProgramLogger.getProgramLogger().getLog();
        ProgramLogger.getProgramLogger().addLogs("first log...");
        ProgramLogger.getProgramLogger().addLogs("second log...");
        ProgramLogger.getProgramLogger().addLogs("third log...");
        ProgramLogger.getProgramLogger().getLog();
    }
}
