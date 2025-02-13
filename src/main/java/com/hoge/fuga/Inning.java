package com.hoge.fuga;

public class Inning {
    private Team offenseTeam;
    private Team defenseTeam;
    private int outs;
    private int runs;

    public Inning(Team offenseTeam, Team defenseTeam) {
        this.offenseTeam = offenseTeam;
        this.defenseTeam = defenseTeam;
        this.outs = 0;
        this.runs = 0;
    }

    public int playInning() {
        while (outs < 3) {
            Fielder batter = (Fielder) offenseTeam.getPlayers().get(1);
            Pitcher pitcher = (Pitcher) defenseTeam.getPlayers().get(0);

            Matchup matchup = new Matchup(pitcher, batter);
            boolean result = matchup.playAtBat();

            if (result) {
                runs++;
            } else {
                outs++;
            }
        }
        return runs;
    }
}
