package com.example.event;

public class ModelL {
    String tname;
    int score;

    public ModelL(String tname, int score) {
        this.tname = tname;
        this.score = score;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
