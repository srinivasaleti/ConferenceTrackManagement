package com.tw;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Represents a component quantity of various measurements used to sequence events
class Time {

    private final String sessionIdentifier;
    private final Duration hours;
    private final Duration minutes;

    private static final String HOUR_TO_MINUTE_SEPARATOR = ":";
    private static final String MINUTE_TO_IDENTIFIER_SEPARATOR = " ";
    private static final String MINUTE_FORMAT = "%02d";

    Time(Duration hour, Duration minute, String sessionIdentifier) {
        this.hours = hour;
        this.minutes = minute;
        this.sessionIdentifier = sessionIdentifier;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        if (this == object) {
            return true;
        }
        Time that = (Time) object;
        boolean sameHours = this.hours.equals(that.hours);
        boolean sameMinutes = this.minutes.equals(that.minutes);
        boolean sameIdentifier = this.sessionIdentifier.equals(that.sessionIdentifier);
        return sameHours && sameMinutes && sameIdentifier;
    }

    String representation() {
        return this.hours.value() + HOUR_TO_MINUTE_SEPARATOR
                + String.format(MINUTE_FORMAT, this.minutes.value())
                + MINUTE_TO_IDENTIFIER_SEPARATOR
                + this.sessionIdentifier;
    }

}
