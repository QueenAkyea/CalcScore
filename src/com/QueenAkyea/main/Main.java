package com.QueenAkyea.main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        String SENTINEL = "square world";
        Scanner sc = new Scanner(System.in);
        String input;

        do {
            System.out.print("> What do you want to do? (scream for help) ");
            input = sc.nextLine();

        } while (!(input.equalsIgnoreCase(SENTINEL)));
    }
}
