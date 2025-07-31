package com.shinkansen;

/**
 * なすの：通常サービス
 */
public class Nasuno extends ShinkansenTrain implements SpeedProvider {
    public Nasuno(StationFilter filter, int maxStops) {
        super(filter, maxStops);
    }

    @Override
    public int getMaxSpeed() {
        return SpeedProvider.super.getMaxSpeed() + 40;
    }
}
