package com.QueenAkyea.main;

import java.util.ArrayList;

public class Contestant implements Comparable{
    public static ArrayList<Contestant> contestants = new ArrayList<>();
    private String name;
    private double score;
    private int numSiblings;
    private double bodyTemp;

    public Contestant(String name, double score, int numSiblings, double bodyTemp) {
        setName(name);
        setScore(score);
        setNumSiblings(numSiblings);
        setBodyTemp(bodyTemp); //owo philbert was here
        contestants.add(this);
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

    @Override
    public int compareTo(Object o) {
        Object other = o;
        if (other instanceof Contestant) {
            return this.getName().compareTo(((Contestant) other).getName());
        }
        throw new ClassCastException();
    }

    public static void commandList() {
        //AAAAAAAAA TODO: implewment owo
    }
}
