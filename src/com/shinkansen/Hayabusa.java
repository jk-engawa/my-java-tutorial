package com.shinkansen;

/**
 * はやぶさ：PremiumService マーカーを実装
 */
public class Hayabusa extends ShinkansenTrain implements PremiumService, SpeedProvider {
    public Hayabusa(StationFilter filter, int maxStops) {
        super(filter, maxStops);
    }

    @Override
    public int getMaxSpeed() {
        // default 実装に上乗せ
        return SpeedProvider.super.getMaxSpeed() + 100;
    }
}
