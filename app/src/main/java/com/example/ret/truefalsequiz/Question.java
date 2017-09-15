package com.example.ret.truefalsequiz;

/**
 * Created by per6 on 9/15/17.
 */

public class Question {
    //instance variables
    private String question;
    private boolean ans;

    //constructor
    public Question(String question, boolean ans) {
        this.question = question;
        this.ans = ans;
    }

    //methods
    public boolean check(boolean ansGiven) { return ansGiven == ans; }

    public String getQuestion() {
        return question;
    }

}
