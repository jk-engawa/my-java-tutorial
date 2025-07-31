package com.shinkansen;

@FunctionalInterface
public interface TrainFilter {
    boolean filter(Train t);
}
