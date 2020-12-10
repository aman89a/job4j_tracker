package ru.job4j.io;

import java.util.Scanner;

public class Dendy {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int rsl = 11;
        String value = "Player 1";
        while (rsl >= 1) {
            System.out.println("player1 ");
            int player1 = Integer.valueOf(input.nextLine());
            if (player1 > 0 && player1 < 4) {
                rsl = rsl - player1;
                value = "Player-1";
            } else {
                System.out.println("не правилный ввод данных");
            }
            System.out.println("player2 ");
            int player2 = Integer.valueOf(input.nextLine());
            if (player2 > 0 && player2 < 4) {
                rsl = rsl - player2;
                value = "Player-2";

            } else {
                System.out.println("не правилный ввод данных");
            }
        }
        System.out.println("Player " + value + " is win.");
    }
}
