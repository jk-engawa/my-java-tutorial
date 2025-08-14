package com.shinkansen;

import java.util.*;

class Nozomi implements ShinkansenService {
    // 代表的な停車駅（簡略）
    private static final Set<Station> STOPS = Set.of(
        Station.TOKYO, Station.SHINAGAWA, Station.SHIN_YOKOHAMA,
        Station.NAGOYA, Station.KYOTO, Station.SHIN_OSAKA
    );
    @Override public String name() { return "のぞみ"; }
    @Override public boolean stopsAt(Station s) { return STOPS.contains(s); }
}
