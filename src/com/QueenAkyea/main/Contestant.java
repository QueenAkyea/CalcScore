package com.QueenAkyea.main;

import com.QueenAkyea.consoleUI.ConsoleColors;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;

public class Contestant{
    private String name;
    private double score;
    private int numSiblings;
    private double bodyTemp;

    public Contestant(String name, double score, int numSiblings, double bodyTemp) {
        setName(name);
        setScore(score);
        setNumSiblings(numSiblings);
        setBodyTemp(bodyTemp); //owo philbert was here
    }

    public Contestant(String name, int numSiblings, double bodyTemp) {
        this(name, 0.0, numSiblings, bodyTemp);
    }

    public Contestant(String name) {
        this(name, 0.0, 0, 98.7);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getNumSiblings() {
        return numSiblings;
    }

    public void setNumSiblings(int numSiblings) {
        this.numSiblings = numSiblings;
    }

    public double getBodyTemp() {
        return bodyTemp;
    }

    public void setBodyTemp(double bodyTemp) {
        this.bodyTemp = bodyTemp;
    }

    @Override
    public String toString() {
        String str = ConsoleColors.CYAN_UNDERLINED + "Contestant " + this.getName() + ": " + ConsoleColors.RESET + "\n" +
                ConsoleColors.WHITE_BRIGHT + "Score: " + this.getScore() + " points\n" +
                "Siblings: " + this.getNumSiblings() + "\n" +
                "Body Temperature: " + this.getBodyTemp() + " degrees Fahrenheit"
                + ConsoleColors.RESET + "\n";
        return str;
    }

    public static void commandList() {

    }

//comparator for name
static class SortByName implements Comparator<Contestant> {
    @Override
    public int compare(Contestant o1, Contestant o2) {
        String name1 = o1.getName().toLowerCase();
        String name2 = o2.getName().toLowerCase();
        return name1.compareTo(name2);
    }
}

//comparator for score
static class SortByScore implements Comparator<Contestant> {
    @Override
    public int compare(Contestant o1, Contestant o2) {
        double score1 = o1.getScore();
        double score2 = o2.getScore();
        if (score1 < score2) {
            return -1;
        } else if (score2 > score1) {
            return 1;
        }
        return 0;
    }
}

    //sort methods
    public static void sortByName(ArrayList<Contestant> contestants) {
        Collections.sort(contestants, new SortByName());
    }

    public static void sortByScore(ArrayList<Contestant> contestants) {
        Collections.sort(contestants, new SortByScore());
    }

    //contestant lookup method
    public static int lookup(ArrayList<Contestant> contestants, String name) {
        sortByName(contestants);
        name = name.toLowerCase();
        return Collections.binarySearch(contestants, new Contestant(name), new SortByName());
    }

}
