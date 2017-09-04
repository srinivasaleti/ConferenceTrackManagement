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

    @Test
    void oneLighteningEqualToFiveMinute() {
        Duration oneLightening = Duration.lightning(1);
        Duration fiveMinute = Duration.minute(5);

        assertEquals(oneLightening, fiveMinute);
    }

    @Test
    void twoLightningEqualToTenMinute() {
        Duration twoLightning = Duration.lightning(2);
        Duration fiveMinute = Duration.minute(10);

        assertEquals(twoLightning, fiveMinute);
    }

}
