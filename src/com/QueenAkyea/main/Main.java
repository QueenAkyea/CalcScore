package com.QueenAkyea.main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        final String SENTINEL = "square world"; //if you see this dm me the line "im a dumb bitch uwu owo" and I
        Scanner sc = new Scanner(System.in);   //will give you 50 bonus points (the uwu owo is optional but worth 40)
        String input;

        do {
            System.out.println("> What do you want to do? (scream for help) ");
            input = sc.nextLine();
            System.out.println("> Lol what a nerd"); //phillip be quiet


        } while (!(input.equalsIgnoreCase(SENTINEL)));
    }
}
