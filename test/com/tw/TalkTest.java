package com.tw;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TalkTest {

    @Test
    void expectedDurationOfPythonTalk() {
        Duration duration = Duration.minute(60);
        String python = "Python";
        Talk pythonTalk = new Talk(python, duration);

        assertEquals(duration, pythonTalk.duration());
    }

    @Test
    void expectedDurationOfJavaTalk() {
        Duration duration = Duration.lightning(2);
        String java = "Java";
        Talk javaTalk = new Talk(java, duration);
        Duration durationInMinute = Duration.minute(10);

        assertEquals(durationInMinute, javaTalk.duration());
    }

    @Test
    void changeStartTimeForJavaTalk() {
        Talk javaTalk = new Talk("Java", Duration.lightning(5));
        Time startTime = new Time(Duration.hour(9), Duration.minute(0), "AM");
        javaTalk.setStartTime(startTime);

        assertEquals(startTime, javaTalk.startTime());
    }

    @Test
    void changeStartTimeForPythonTalk() {
        Talk pythonTalk = new Talk("Python", Duration.lightning(5));
        Time startTime = new Time(Duration.hour(1), Duration.minute(0), "PM");
        pythonTalk.setStartTime(startTime);

        assertEquals(startTime, pythonTalk.startTime());
    }

    @Test
    void expectedRepresentationOfPythonTalk() {
        Talk pythonTalk = new Talk("Python", Duration.lightning(5));
        Time startTime = new Time(Duration.hour(1), Duration.minute(0), "PM");
        pythonTalk.setStartTime(startTime);
        String pythonTalkRepresentation = "1:00 PM Python 5 Lightnings";

        assertEquals(pythonTalkRepresentation, pythonTalk.representation());
    }

    @Test
    void expectedRepresentationOfJavaTalk() {
        Talk javaTalk = new Talk("Java", Duration.minute(5));
        Time startTime = new Time(Duration.hour(9), Duration.minute(0), "AM");
        javaTalk.setStartTime(startTime);
        String javaTalkRepresentation = "9:00 AM Java 5 Minutes";

        assertEquals(javaTalkRepresentation, javaTalk.representation());
    }

}
