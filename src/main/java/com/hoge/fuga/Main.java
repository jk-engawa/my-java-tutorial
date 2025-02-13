package com.hoge.fuga;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Pitcher pitcherA = new Pitcher("A-Pitcher", 30);
        pitcherA.addPitchSkill("Fastball", 80);
        pitcherA.addPitchSkill("Curveball", 70);

        Fielder batterA = new Fielder("A-Batter", 30);
        batterA.addPitchPreference("Fastball", 20);
        batterA.addPitchPreference("Curveball", -10);

        List<Player> teamAPlayers = new ArrayList<>();
        teamAPlayers.add(pitcherA);
        teamAPlayers.add(batterA);

        Team teamA = new Team("Lions", teamAPlayers);
        Team teamB = new Team("Tigers", teamAPlayers);

        Game game = new Game(teamA, teamB);
        game.startGame();
    }
}
