package com.QueenAkyea.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class Contestant implements Comparable<Contestant>{
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
        return "Contestant " + this.name;
    }

    public static void commandList() {

    }

    @Override
    public int compareTo(Contestant o) {
        String name1 = this.getName().toLowerCase();
        String name2 = o.getName().toLowerCase();
        return name1.compareTo(name2);
        //return this.getName().compareTo(o.getName());
    }

    public static int lookup(ArrayList<Contestant> contestants, String name) {
        Collections.sort(contestants);
        name = name.toLowerCase();
        return Collections.binarySearch(contestants, new Contestant(name));
    }

}
