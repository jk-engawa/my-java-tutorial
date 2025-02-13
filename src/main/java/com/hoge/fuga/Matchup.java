package com.hoge.fuga;

public class Matchup {
    private Pitcher pitcher;
    private Fielder batter;

    public Matchup(Pitcher pitcher, Fielder batter) {
        this.pitcher = pitcher;
        this.batter = batter;
    }

    public boolean playAtBat() {
        String pitchType = pitcher.pitch();
        int pitchAccuracy = pitcher.getPitchAccuracy(pitchType);

        boolean result = batter.bat(pitchType, pitchAccuracy);
        if (result) {
            System.out.println(batter.getName() + " hits!");
        } else {
            System.out.println(batter.getName() + " is out!");
        }
        return result;
    }
}
