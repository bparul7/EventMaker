package com.example.event;

public class ModelL {
    String tname;
    int score;
    int tid;

    public ModelL(String tname, int score,int tid) {
        this.tname = tname;
        this.score = score;
        this.tid=tid;
    }

    public String getTname() {
        return tname;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
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
