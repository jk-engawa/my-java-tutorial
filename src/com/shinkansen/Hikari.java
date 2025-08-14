package com.shinkansen;

import java.util.*;

class Hikari implements ShinkansenService {
    // のぞみ + 追加停車（簡略）
    private static final Set<Station> STOPS = Set.of(
        Station.TOKYO, Station.SHINAGAWA, Station.SHIN_YOKOHAMA,
        Station.SHIN_FUJI, Station.SHIZUOKA, Station.HAMAMATSU, Station.TOYOHASHI,
        Station.NAGOYA, Station.GIFU_HASHIMA, Station.MAIBARA, Station.KYOTO, Station.SHIN_OSAKA
    );
    @Override public String name() { return "ひかり"; }
    @Override public boolean stopsAt(Station s) { return STOPS.contains(s); }
}