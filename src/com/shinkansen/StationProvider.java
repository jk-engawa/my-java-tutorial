package com.shinkansen;

import java.util.Arrays;
import java.util.List;

public interface StationProvider {
    default List<String> getStations() {
        return Arrays.asList("Tokyo", "Ueno", "Sendai", "Morioka", "Shin-Aomori");
    }
}
