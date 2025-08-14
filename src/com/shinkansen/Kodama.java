package com.shinkansen;

import java.util.*;

class Kodama implements ShinkansenService {
    // ほぼ各駅（簡略）
    private static final Set<Station> STOPS = EnumSet.of(
        Station.TOKYO, Station.SHINAGAWA, Station.SHIN_YOKOHAMA,
        Station.ODAWARA, Station.ATAMI, Station.MISHIMA, Station.SHIN_FUJI, Station.SHIZUOKA,
        Station.KAKEGAWA, Station.HAMAMATSU, Station.TOYOHASHI,
        Station.NAGOYA, Station.GIFU_HASHIMA, Station.MAIBARA, Station.KYOTO, Station.SHIN_OSAKA
    );
    @Override public String name() { return "こだま"; }
    @Override public boolean stopsAt(Station s) { return STOPS.contains(s); }
}