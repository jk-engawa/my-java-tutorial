package com.shinkansen;

@FunctionalInterface
public interface StationFilter {
    boolean filter(String station);
}
