package com.QueenAkyea.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Contest {
    private ArrayList<Contestant> contestants;
    private int rounds;
    private int numContestants;

    public Contest(ArrayList<Contestant> contestants) {
        this.contestants = contestants;
        rounds = 0;
        numContestants = contestants.size();
    }

    public Contest() {
        this(new ArrayList<Contestant>());
    }

    public String contestants() { //TODO: fix lol
        return contestants.toString();
    }

    //contestants is always sorted
    public void addContestant(Contestant c) {
        contestants.add(c);
        numContestants++;
        Collections.sort(contestants);
    }

    public void createContestant(String name, double score, int numSiblings, double bodyTemp) {
        Contestant c = new Contestant(name, score, numSiblings, bodyTemp);
        this.addContestant(c);
    }

    public void createContestant() {
        Scanner sc = new Scanner(System.in);
        boolean gun = true;
        double score = 0.0;
        int numSiblings = 0;
        double bodyTemp = 0.0;

        while (gun) {
            System.out.println("> What is their name?");
            String name = sc.next();

            //contestant's starting score
            boolean validInput = false;
            while (!validInput) {
                try {
                    System.out.println("> Would you like to give them a starting score? (y/n)");
                    String input = sc.nextLine();
                    if (input.equals("y")) {
                        try {
                            System.out.println("> What would you like their score to be?");
                            score = sc.nextDouble();
                        } catch (InputMismatchException a) {
                            System.out.println(ConsoleColors.RED_BOLD+ "⚠ NOT A VALID SCORE >:( ⚠" + ConsoleColors.RESET);
                            System.out.println(ConsoleColors.BLUE + "*doubles must be in decimal format" + ConsoleColors.RESET);
                        }
                    } else if (input.equals(("n"))){
                        score = 0;
                    } else {
                        throw new InputMismatchException();
                    }
                    validInput = true;
                } catch (InputMismatchException a) {
                    System.out.println(ConsoleColors.RED_BOLD+ "⚠ NOT A VALID RESPONSE >:( ⚠" + ConsoleColors.RESET);
                }
            }
            //contestant's siblings
            boolean validNum = false;
            while (!validNum) {
                try {
                    System.out.println("> How many siblings do they have?");
                    numSiblings = sc.nextInt();
                    validNum = true;
                } catch (InputMismatchException a) {
                    System.out.println(ConsoleColors.RED_BOLD+ "⚠ NOT A VALID NUMBER >:( ⚠" + ConsoleColors.RESET);
                    System.out.println(ConsoleColors.BLUE + "*this number cannot have a decimal" + ConsoleColors.RESET);
                }
            }
            //contestant's body temperature
            boolean validTemp = false;
            while (!validTemp) {
                try {
                    System.out.println("> What is their body temperature?");
                    bodyTemp = sc.nextDouble();
                    validTemp = true;
                } catch (InputMismatchException a) {
                    System.out.println(ConsoleColors.RED_BOLD+ "⚠ NOT A VALID TEMPERATURE >:( ⚠" + ConsoleColors.RESET);
                    System.out.println(ConsoleColors.BLUE + "*doubles must be in decimal format" + ConsoleColors.RESET);
                }
            }
            //adds new contestant to the contest
            this.createContestant(name, score, numSiblings, bodyTemp);
            System.out.println(ConsoleColors.BLUE + "Added contestant \"" + name + "\"" + ConsoleColors.RESET);

            //prompts user if they want to add another contestant
            validInput = false;
            while (!validInput) {
                try {
                    System.out.println("> Would you like to add another contestant? (y/n)");
                    String input = sc.nextLine();
                    if (input.equals("y")) {

                    } else if (input.equals("n")) {
                        gun = false;
                    }
                    validInput = true;
                } catch (InputMismatchException a) {
                    System.out.println(ConsoleColors.RED_BOLD+ "⚠ NOT A VALID RESPONSE >:( ⚠" + ConsoleColors.RESET);
                }
            }
        }
    }

    public void endRound() {
        rounds++;

    } //TODO: implement

    /* TODO:
     *   implement addContestant *
     *   implement findContestant
     *   implement lol
     *   implement listInfo
     */

}
