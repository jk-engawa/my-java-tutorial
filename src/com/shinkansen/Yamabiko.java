package com.shinkansen;

/**
 * やまびこ：通常サービス
 */
public class Yamabiko extends ShinkansenTrain implements SpeedProvider {
    public Yamabiko(StationFilter filter, int maxStops) {
        super(filter, maxStops);
    }

    @Override
    public int getMaxSpeed() {
        return SpeedProvider.super.getMaxSpeed() + 60;
    }
}
