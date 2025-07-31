package com.shinkansen;

import java.util.List;
import java.util.Iterator;
import java.util.stream.Collectors;

/**
 * 新幹線共通の振る舞いを提供する抽象クラス
 */
public abstract class ShinkansenTrain extends Train
        implements StationProvider, SpeedProvider, Iterable<String> {

    protected final List<String> stops;

    public ShinkansenTrain(StationFilter filter, int maxStops) {
        // インタフェース default の呼び出し
        List<String> base = StationProvider.super.getStations();
        this.stops = base.stream()
                         .filter(filter::filter)
                         .limit(maxStops)
                         .collect(Collectors.toList());
    }

    @Override
    public void depart() {
        super.depart();  // Train.depart()
        System.out.println(
            this.getClass().getSimpleName() +
            " が時速 " + getMaxSpeed() + " km/h で出発！"
        );
        System.out.println("停車駅：");
        for (String s : this) {
            System.out.println(" - " + s);
        }
    }

    @Override
    public Iterator<String> iterator() {
        return stops.iterator();
    }
}
