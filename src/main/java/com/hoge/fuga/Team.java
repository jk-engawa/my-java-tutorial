package com.hoge.fuga;

import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name, List<Player> players) {
        this.name = name;
        this.players = players;
    }

    public String getName() {
        return name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void showTeam() {
        System.out.println("Team: " + name);
        for (Player player : players) {
            System.out.println("- " + player.getName() + " (" + player.getPosition() + ")");
        }
    }
}
