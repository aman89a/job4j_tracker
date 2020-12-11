package ru.job4j.io;

import java.util.Scanner;

public class Dendy {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int rsl = 11;
        boolean change = true;
        String value = null;
        while (rsl >= 1) {
            value = change ? "player-1" : "player-2";
            System.out.println(value);
            int num = Integer.valueOf(input.nextLine());
            if (change && num > 0 && num < 4) {
                rsl -= num;
                change = false;
            } else if (!change && num > 0 && num < 4){
                rsl -= num;
                change = true;
            } else {
                System.out.println("Input is wrong!");
            }
        }
            System.out.println(value + " is win!");
    }
}
