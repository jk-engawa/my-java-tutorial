package com.shinkansen;

public interface SpeedProvider {
    default int getBaseSpeed() {
        return 240;
    }
    default int getMaxSpeed() {
        return getBaseSpeed();
    }
}
