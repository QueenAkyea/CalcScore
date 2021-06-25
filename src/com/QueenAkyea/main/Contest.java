package com.QueenAkyea.main;

import java.util.ArrayList;

public class Contest {
    private ArrayList<Contestant> contestants;
    private int rounds;
    //private int numContestants;

    public Contest(ArrayList<Contestant> contestants) {
        this.contestants = contestants;
    }

    public Contest() {
        this(new ArrayList<Contestant>());
    }

    public String contestants() { //TODO: fix lol
        return contestants.toString();
    }

    /* TODO:
     *   implement addContestant
     *   implement findContestant
     *   implement lol
     */

}
