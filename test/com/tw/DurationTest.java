package com.tw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void fiveMinutesMoreThanTwoMinutes() {
        Duration fiveMinutes = Duration.minute(5);
        Duration twoMinutes = Duration.minute(2);

        assertTrue(fiveMinutes.isMoreThanOrEqualOf(twoMinutes));
    }

    @Test
    void fiveMinutesIsNotMoreThanOrEqualOfTwoLightnings() {
        Duration fiveMinute = Duration.minute(5);
        Duration twoLightning = Duration.lightning(2);

        assertFalse(fiveMinute.isMoreThanOrEqualOf(twoLightning));
    }

    @Test
    void expectedBaseValueOfFiveMinutes() {
        int value = 5;
        Duration fiveMinutes = Duration.minute(value);

        assertEquals(value, fiveMinutes.baseValue());
    }

    @Test
    void expectedBaseValueOfTwoLightnings() {
        int value = 2;
        int baseValue = 10;
        Duration twoLightnings = Duration.lightning(value);

        assertEquals(baseValue, twoLightnings.baseValue());
    }

    @Test
    void representationOfNineMinutes() {
        Duration minute = Duration.minute(9);
        String nineMinutes = "9 Minutes";

        assertEquals(nineMinutes, minute.representation());
    }

    @Test
    void representationOfFiveLightnings() {
        Duration lightning = Duration.lightning(9);
        String nineLightnings = "9 Lightnings";

        assertEquals(nineLightnings, lightning.representation());
    }

    @Test
    void expectedValueFiveMinutes() {
        int value = 5;
        Duration fiveMinutes = Duration.minute(value);

        assertEquals(value, fiveMinutes.value());
    }

    @Test
    void expectedValueOfTwoLightnings() {
        int value = 2;
        Duration twoLightnings = Duration.lightning(value);

        assertEquals(value, twoLightnings.value());
    }

}
