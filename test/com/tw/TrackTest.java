package com.tw;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TrackTest {

    @Test
    void addTalkToASession() {
        Talk talk = new Talk("Java", Duration.minute(60));
        Track track = new Track();
        String expected = "9:00 AM Java 60 Minutes" + "\n12:00 PM Lunch 60 Minutes\n";

        track.addTalkInASession(talk);

        assertEquals(expected, track.representation());
    }

    @Test
    void addMultipleTalksToTrack() {
        Talk javaTalk = new Talk("Java", Duration.minute(180));
        Talk pythonTalk = new Talk("Python", Duration.lightning(5));
        Track track = new Track();
        String expected = "9:00 AM Java 180 Minutes\n" +
                "12:00 PM Lunch 60 Minutes\n" +
                "1:00 PM Python 5 Lightnings\n";

        track.addTalkInASession(javaTalk);
        track.addTalkInASession(pythonTalk);

        assertEquals(expected, track.representation());
    }

}
