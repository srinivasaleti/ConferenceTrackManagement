package com.tw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class TimeTest {

    private Time time;

    @BeforeEach
    void setUp() {
        Duration hour = Duration.hour(9);
        Duration minute = Duration.minute(0);
        this.time = new Time(hour, minute, "AM");
    }

    @Test
    void timeNotEqualToNull() {
        assertNotEquals(time, null);
    }

    @Test
    void timeNotEqualToString() {
        assertNotEquals(time, "Time");
    }

    @Test
    void timeEqualToItSelf() {
        assertEquals(time, time);
    }

    @Test
    void timeEqualsToSameTime() {
        Duration minute = Duration.minute(0);
        Duration hour = Duration.hour(9);
        Time sameTime = new Time(hour, minute, "AM");
        assertEquals(time, sameTime);
    }

    @Test
    void expectedRepresentationsOfNineAM() {
        Duration hour = Duration.hour(9);
        Duration minute = Duration.minute(0);
        Time time = new Time(hour, minute, "AM");
        String nineAm = "9:00 AM";

        assertEquals(nineAm, time.representation());
    }

    @Test
    void expectedRepresentationOfOneThirtyPM() {
        Duration hour = Duration.hour(1);
        Duration minute = Duration.minute(30);
        Time time = new Time(hour, minute, "PM");
        String oneThirtyPM = "1:30 PM";

        assertEquals(oneThirtyPM, time.representation());
    }

}
