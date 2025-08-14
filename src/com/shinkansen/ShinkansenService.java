package com.shinkansen;

import java.util.*;

interface ShinkansenService {
    String name();
    boolean stopsAt(Station s);
    default Set<Station> allStops() {
        Set<Station> set = new LinkedHashSet<>();
        for (Station st : Station.values()) if (stopsAt(st)) set.add(st);
        return set;
    }
}