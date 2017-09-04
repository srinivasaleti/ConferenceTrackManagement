package com.tw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class DurationTest {

    private Duration duration;
    private int value = 1;
    private int conversionFactor = 1;
    private String minute = "Minute";

    @BeforeEach
    void setUp() {
        duration = new Duration(value, conversionFactor, minute);
    }

    @Test
    void durationNotEqualToNull() {
        assertNotEquals(duration, null);
    }

    @Test
    void durationNotEqualToString() {
        String durationString = "Duration";

        assertNotEquals(duration, durationString);
    }

    @Test
    void durationEqualToItSelf() {
        assertEquals(duration, duration);
    }

    @Test
    void durationEqualToSameDuration() {
        Duration sameDuration = new Duration(value, conversionFactor, minute);

        assertEquals(duration, sameDuration);
    }

}
