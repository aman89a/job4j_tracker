package ru.job4j.io;

import java.util.Scanner;

public class Dendy {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int rsl = 11;
        while (rsl >= 1) {
            int player1 = Integer.valueOf(input.nextLine());
            if (player1 > 0 && player1 < 4) {
                System.out.println("player1 " + player1);
                rsl = rsl - player1;
                System.out.println(rsl);
            } else {
                System.out.println("не правилный ввод данных");
            }
            int player2 = Integer.valueOf(input.nextLine());
            if (player2 > 0 && player2 < 4) {
                System.out.println("player2 " + player2);
                rsl = rsl - player2;
                System.out.println(rsl);
            } else {
                System.out.println("не правилный ввод данных");
            }
            System.out.println(rsl);
        }
    }
}
