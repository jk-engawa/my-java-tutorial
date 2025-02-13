package com.hoge.fuga;

import java.util.HashMap;
import java.util.Map;

public class Pitcher extends Player {
    private Map<String, Integer> pitchSkills;
    private int strikeOutRate;

    public Pitcher(String name, int strikeOutRate) {
        super(name, "Pitcher");
        this.strikeOutRate = strikeOutRate;
        this.pitchSkills = new HashMap<>();
    }

    public void addPitchSkill(String pitchType, int accuracy) {
        pitchSkills.put(pitchType, accuracy);
    }

    public String pitch() {
        Object[] pitches = pitchSkills.keySet().toArray();
        String pitchType = (String) pitches[(int) (Math.random() * pitches.length)];
        System.out.println(getName() + " throws a " + pitchType + "!");
        return pitchType;
    }

    public int getPitchAccuracy(String pitchType) {
        return pitchSkills.getOrDefault(pitchType, 0);
    }

    @Override
    public void play() {
        System.out.println(getName() + " is pitching.");
    }
}
