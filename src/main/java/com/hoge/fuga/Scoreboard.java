package com.hoge.fuga;

public class Scoreboard {
    private String teamA;
    private String teamB;
    private int totalScoreA;
    private int totalScoreB;

    public Scoreboard(String teamA, String teamB) {
        this.teamA = teamA;
        this.teamB = teamB;
    }

    public void updateInningScore(int inning, int scoreA, int scoreB) {
        totalScoreA += scoreA;
        totalScoreB += scoreB;
    }

    public void displayScore() {
        System.out.println("Final Score: " + teamA + " " + totalScoreA + " - " + teamB + " " + totalScoreB);
    }
}
