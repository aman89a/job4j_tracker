package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] leftChars = left.split(". ");
        String[] rightChars = right.split(". ");
        int num1 = Integer.parseInt(leftChars[0]);
        int num2 = Integer.parseInt(rightChars[0]);
        return Integer.compare(num1, num2);
    }
}
