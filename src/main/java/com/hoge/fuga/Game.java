package com.hoge.fuga;

public class Game {
    private Team teamA;
    private Team teamB;
    private Scoreboard scoreboard;

    public Game(Team teamA, Team teamB) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.scoreboard = new Scoreboard(teamA.getName(), teamB.getName());
    }

    public void startGame() {
        for (int inning = 1; inning <= 9; inning++) {
            int scoreA = new Inning(teamA, teamB).playInning();
            int scoreB = new Inning(teamB, teamA).playInning();
            scoreboard.updateInningScore(inning, scoreA, scoreB);
        }
        scoreboard.displayScore();
    }
}
