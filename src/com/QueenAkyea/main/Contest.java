package com.QueenAkyea.main;

import java.util.ArrayList;
import java.util.Collections;

public class Contest {
    private ArrayList<Contestant> contestants;
    private int rounds;
    //private int numContestants;

    public Contest(ArrayList<Contestant> contestants) {
        this.contestants = contestants;
        rounds = 0;
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
        Collections.sort(contestants);
    }

    public void createContestant(String name, double score, int numSiblings, double bodyTemp) {
        Contestant c = new Contestant(name, score, numSiblings, bodyTemp);
        addContestant(c);
    }

    public void endRound() {
        rounds++;

    }

    /* TODO:
     *   implement addContestant *
     *   implement findContestant
     *   implement lol
     *   implement listInfo
     */

}
