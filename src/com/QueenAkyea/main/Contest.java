package com.QueenAkyea.main;

import com.QueenAkyea.main.consoleUI.ConsoleColors;
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
        this(new ArrayList<Contestant>(0));
    }

    public ArrayList<Contestant> getContestants() {
        return contestants;
    }

    public void setContestants(ArrayList<Contestant> contestants) {
        this.contestants = contestants;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public int getNumContestants() {
        return numContestants;
    }

    public void setNumContestants(int numContestants) {
        this.numContestants = numContestants;
    }

    public void listContestants() {
        if (this.getNumContestants() < 1) {
            System.out.println(ConsoleColors.RED_BOLD + "⚠ YOU DO NOT YET HAVE ANY CONTESTANTS ADDED >:( ⚠"
                             + ConsoleColors.RESET);
        } else {
            String leftAlignFormat = "| %-15s | %-4.3f   | %-2d         | %-3.2f      |%n";

            System.out.format("+-----------------+---------+------------+-----------+%n");
            System.out.format("| Contestant name | Score   | # siblings | Body temp |%n");
            System.out.format("+-----------------+---------+------------+-----------+%n");
            for (int i = 0; i < contestants.size(); i++) {
                Contestant c = contestants.get(i);
                System.out.format(leftAlignFormat, c.getName(), c.getScore(), c.getNumSiblings(), c.getBodyTemp());
            }
            System.out.format("+-----------------+---------+------------+-----------+%n");
        }
    }

    //contestants is always sorted
    private void addContestant(Contestant c) {
        contestants.add(c);
        numContestants++;
        Collections.sort(contestants);
    }

    private void createContestant(String name, double score, int numSiblings, double bodyTemp) {
        Contestant c = new Contestant(name, score, numSiblings, bodyTemp);
        this.addContestant(c);
    }

    public void createContestant() {
        Scanner sc = new Scanner(System.in);
        boolean gun = true;
        String name = "";
        double score = 0.0;
        int numSiblings = 0;
        double bodyTemp = 0.0;

        while (gun) {
            //contestant's name
            boolean validName = false;
            while (!validName) {
                System.out.println("> What is their name?");
                name = sc.nextLine();
                if (isDuplicateContestant(name)) {
                    System.out.println(ConsoleColors.RED_BOLD + "⚠ NAME ALREADY TAKEN >:( ⚠" + ConsoleColors.RESET);
                } else {
                    validName = true;
                }
            }
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
                            System.out.println(ConsoleColors.BLUE + "*doubles may be in decimal format" + ConsoleColors.RESET);
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
                sc.nextLine();
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
                    System.out.println(ConsoleColors.BLUE + "*doubles may be in decimal format" + ConsoleColors.RESET);
                }
                sc.nextLine();
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
                    } else {
                        throw new InputMismatchException();
                    }
                    validInput = true;
                } catch (InputMismatchException a) {
                    System.out.println(ConsoleColors.RED_BOLD+ "⚠ NOT A VALID RESPONSE >:( ⚠" + ConsoleColors.RESET);
                }
            }
        }
    }

    public boolean isDuplicateContestant(String name) {
        int ind = Contestant.lookup(contestants, name);
        if (ind >= 0) {
            return true;
        }
        return false;
    }

    public void searchContestant(String name) {
        int ind = Contestant.lookup(contestants, name);
        if (ind < 0) {
            System.out.println("> Contestant does not exist");
        } else {
            Contestant c = contestants.get(ind);
            System.out.println("> Found contestant " + ConsoleColors.BLUE + c.getName() + ConsoleColors.RESET);

        }
    }

    public void endRound() {
        rounds++;

    }
}
