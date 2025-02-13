package com.hoge.fuga;

import java.util.HashMap;
import java.util.Map;

public class Fielder extends Player {
    private int battingAverage;
    private Map<String, Integer> pitchPreferences;

    public Fielder(String name, int battingAverage) {
        super(name, "Fielder");
        this.battingAverage = battingAverage;
        this.pitchPreferences = new HashMap<>();
    }

    public void addPitchPreference(String pitchType, int effectiveness) {
        pitchPreferences.put(pitchType, effectiveness);
    }

    public boolean bat(String pitchType, int pitchAccuracy) {
        int preference = pitchPreferences.getOrDefault(pitchType, 0);
        int chance = battingAverage + preference - pitchAccuracy;
        int result = (int) (Math.random() * 100);
        return result < chance;
    }

    @Override
    public void play() {
        System.out.println(getName() + " is batting.");
    }
}
