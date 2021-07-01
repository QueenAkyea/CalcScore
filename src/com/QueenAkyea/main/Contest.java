package com.QueenAkyea.main;

import com.QueenAkyea.consoleUI.ConsoleColors;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Contest {
    private String name;
    private ArrayList<Contestant> contestants;
    private int rounds;
    private int numContestants;

    public Contest(String name) {
        if (name.equals(" ") || name.length() < 1) {
            this.name = "Competition";
        } else {
            this.name = name + " Competition";
        }
        this.contestants = new ArrayList<Contestant>(0);
        this.rounds = 0;
        this.numContestants = 0;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Contestant> getContestants() {
        return contestants;
    }

    public int getRounds() {
        return rounds;
    }

    private void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public int getNumContestants() {
        return numContestants;
    }

    public void listInfo() {
        //maybe i'll add ascii art. maybe i wont
        System.out.println(getName());
        if (this.getNumContestants() < 1) {
            System.out.println("\n\n\n");
            System.out.println("you do not have any contestants yet.");
            System.out.println("\n\n\n");
        } else {
            System.out.println(ConsoleColors.BLUE + getNumContestants() + " contestants:" + ConsoleColors.RESET);
            listContestants();
            System.out.println("---------------------------------");
            System.out.println(ConsoleColors.BLUE + "Rounds so far: " + getRounds() + ConsoleColors.RESET);
            listStandings();
            System.out.println("---------------------------------");
        }

    }

    //PRECONDITION: numContestants > 0
    public void listContestants() {
        if (this.getNumContestants() < 1) {
            System.out.println(ConsoleColors.RED_BOLD + "⚠ YOU DO NOT YET HAVE ANY CONTESTANTS ADDED >:( ⚠"
                             + ConsoleColors.RESET);
        } else {
            for (Contestant c: contestants) {
                System.out.println(c.toString());
            }
            /*System.out.println(ConsoleColors.CYAN_UNDERLINED + "Contestant " + contestants.get(0).getName() + ": "
                             + ConsoleColors.RESET);
            System.out.println(ConsoleColors.GREEN_BOLD + "Score: " + contestants.get(0).getScore() + " points");
            System.out.println("Siblings: " + contestants.get(0).getNumSiblings());
            System.out.println("Body Temperature: " + contestants.get(0).getBodyTemp() + " degrees Fahrenheit"
                             + ConsoleColors.RESET);
            for (int i = 1; i < contestants.size(); i++) {
                System.out.println(ConsoleColors.CYAN_UNDERLINED + "Contestant " + contestants.get(i).getName() + ": "
                        + ConsoleColors.RESET);
                System.out.println(ConsoleColors.GREEN_BOLD + "Score: " + contestants.get(i).getScore() + " points");
                System.out.println("Siblings: " + contestants.get(i).getNumSiblings());
                System.out.println("Body Temperature: " + contestants.get(i).getBodyTemp() + " degrees Fahrenheit"
                        + ConsoleColors.RESET);
            }*/
            /*String leftAlignFormat = "| %-15s | %-4.3f   | %-2d         | %-3.2f      |%n";

            System.out.format("+-----------------+---------+------------+-----------+%n");
            System.out.format("| Contestant name | Score   | # siblings | Body temp |%n");
            System.out.format("+-----------------+---------+------------+-----------+%n");
            for (int i = 0; i < contestants.size(); i++) {
                Contestant c = contestants.get(i);
                System.out.format(leftAlignFormat, c.getName(), c.getScore(), c.getNumSiblings(), c.getBodyTemp());
            }
            System.out.format("+-----------------+---------+------------+-----------+%n");*/
        }
    }

    //PRECONDITION: numContestants > 0
    public void listStandings() {
        if (this.getNumContestants() < 1) {
            System.out.println(ConsoleColors.RED_BOLD + "⚠ YOU DO NOT YET HAVE ANY CONTESTANTS ADDED >:( ⚠"
                    + ConsoleColors.RESET);
        } else {
            Contestant.sortByScore(contestants);
            int i = 1;
            for (Contestant c: contestants) {
                System.out.println(i + ". " + c.getName() + " with a score of " + c.getScore() + " points.");
                i++;
            }
            Contestant.sortByName(contestants);
        }
    }

    //contestants is always sorted
    private void addContestant(String name, double score, int numSiblings, double bodyTemp) {
        Contestant c = new Contestant(name, score, numSiblings, bodyTemp);
        contestants.add(c);
        numContestants++;
        Contestant.sortByName(contestants);
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
                    String input = sc.nextLine().toLowerCase();
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
            this.addContestant(name, score, numSiblings, bodyTemp);
            System.out.println(ConsoleColors.BLUE + "Added contestant \"" + name + "\"" + ConsoleColors.RESET);
            //prompts user if they want to add another contestant
            validInput = false;
            while (!validInput) {
                try {
                    System.out.println("> Would you like to add another contestant? (y/n)");
                    String input = sc.nextLine().toLowerCase();
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

    //PRECONDITION: numContestants > 0
    public void deleteContestant() {
        if (this.getNumContestants() < 1) {
            System.out.println(ConsoleColors.RED_BOLD + "⚠ YOU DO NOT YET HAVE ANY CONTESTANTS ADDED >:( ⚠"
                    + ConsoleColors.RESET);
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.println("> Enter the name of the contestant you want to remove");
            String name = sc.nextLine();
            int ind = Contestant.lookup(contestants, name);

            if (ind < 0) {
                System.out.println(ConsoleColors.RED_BOLD + "⚠ Contestant does not exist >:( ⚠" + ConsoleColors.RESET);
            } else {
                name = contestants.get(ind).getName();
                contestants.remove(ind);
                numContestants--;
                System.out.println(ConsoleColors.BLUE+ "> Removed contestant " + name + ConsoleColors.RESET);
            }
        }
    }

    private boolean isDuplicateContestant(String name) {
        int ind = Contestant.lookup(contestants, name);
        if (ind >= 0) {
            return true;
        }
        return false;
    }

    //PRECONDITION: numContestants > 0
    public void findContestant() {
        if (this.getNumContestants() < 1) {
            System.out.println(ConsoleColors.RED_BOLD + "⚠ YOU DO NOT YET HAVE ANY CONTESTANTS ADDED >:( ⚠"
                    + ConsoleColors.RESET);
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.println("> Enter the name of the contestant you are looking for");
            String name = sc.nextLine();

            int ind = Contestant.lookup(contestants, name);
            if (ind < 0) {
                System.out.println(ConsoleColors.RED_BOLD + "⚠ Contestant does not exist >:( ⚠" + ConsoleColors.RESET);
            } else {
                Contestant c = contestants.get(ind);
                System.out.println(c.toString());
            }
        }
    }

    public void endRound() {
        rounds++;

    }
}
