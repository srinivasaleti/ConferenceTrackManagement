package com.tw;

import java.util.ArrayList;

class Track {

    private static final Time MORNING_SESSION_STARTING_TIME = new Time(Duration.hour(9), Duration.minute(0), "AM");
    private static final Time LUNCH_SESSION_STARTING_TIME = new Time(Duration.hour(12), Duration.minute(0), "PM");
    private static final Time AFTERNOON_SESSION_STARTING_TIME = new Time(Duration.hour(1), Duration.minute(0), "PM");
    private static final Duration MORNING_SESSION_DURATION = Duration.minute(180);
    private static final Duration LUNCH_SESSION_DURATION = Duration.minute(60);
    private static final Duration AFTERNOON_SESSION_DURATION = Duration.minute(240);
    private static final Talk LUNCH_TALK = new Talk("Lunch", Duration.minute(60));

    private Session morningSession;
    private Session lunchSession;
    private Session afterNoonSession;

    Track() {
        this.morningSession = new Session(new ArrayList<>(), MORNING_SESSION_STARTING_TIME, MORNING_SESSION_DURATION);
        this.afterNoonSession = new Session(new ArrayList<>(), AFTERNOON_SESSION_STARTING_TIME, AFTERNOON_SESSION_DURATION);
        this.lunchSession = new Session(new ArrayList<>(), LUNCH_SESSION_STARTING_TIME, LUNCH_SESSION_DURATION);
        this.lunchSession.addATalk(LUNCH_TALK);
    }

    void addTalkInASession(Talk talk) {
        if (this.morningSession.hasDurationOf(talk.duration())) {
            this.morningSession.addATalk(talk);
            return;
        }
        this.afterNoonSession.addATalk(talk);
    }

    public String representation() {
        return this.morningSession.representation()
                + this.lunchSession.representation()
                + this.afterNoonSession.representation();
    }

    boolean hasDurationOf(Duration duration) {
        return this.morningSession.hasDurationOf(duration) || this.afterNoonSession.hasDurationOf(duration);
    }

}
