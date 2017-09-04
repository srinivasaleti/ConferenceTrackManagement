package com.tw;

//Represents a component quantity of various measurements used to sequence events
class Time {

    private static final String HOUR_TO_MINUTE_SEPARATOR = ":";
    private static final String MINUTE_TO_IDENTIFIER_SEPARATOR = " ";
    private static final String MINUTE_FORMAT = "%02d";
    private static final String AFTERNOON_IDENTIFIER = "PM";
    private static final String FORENOON_IDENTIFIER = "AM";

    private static final int START_TIME_OF_AFTERNOON = 12;
    private static final int THIRTEEN_HOURS = 13;
    private static final int MAX_MINUTE_VALUE = 60;
    private static final int START_TIME_OF_AFTERNOON_SESSION = 1;
    private static final int END_TIME_OF_AFTERNOON_SESSION = 5;

    private final Duration hours;
    private final Duration minutes;
    private String sessionIdentifier;

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

    Time timeAfter(Duration offset) {
        int nextMinuteValue = this.minutes.baseValue() + offset.baseValue();
        int nextHourValue = this.hours.value();
        return timeBasedOn(nextMinuteValue, nextHourValue);
    }

    private Time timeBasedOn(int minuteValue, int hourValue) {
        String identifier;
        if (minuteValue >= MAX_MINUTE_VALUE) {
            int extraHours = minuteValue / MAX_MINUTE_VALUE;
            hourValue = (hourValue + extraHours) % START_TIME_OF_AFTERNOON;
            minuteValue = minuteValue % MAX_MINUTE_VALUE;
        }
        identifier = identifierBasedOn(hourValue);
        if (hourValue >= THIRTEEN_HOURS) {
            hourValue = hourValue - START_TIME_OF_AFTERNOON;
        }
        return new Time(Duration.hour(hourValue), Duration.minute(minuteValue), identifier);
    }

    private String identifierBasedOn(int hourValue) {
        String identifier = FORENOON_IDENTIFIER;
        if (hourValue >= START_TIME_OF_AFTERNOON_SESSION && hourValue <= END_TIME_OF_AFTERNOON_SESSION) {
            identifier = AFTERNOON_IDENTIFIER;
        }
        return identifier;
    }

    String representation() {
        return this.hours.value() + HOUR_TO_MINUTE_SEPARATOR
                + String.format(MINUTE_FORMAT, this.minutes.value())
                + MINUTE_TO_IDENTIFIER_SEPARATOR
                + this.sessionIdentifier;
    }

}
