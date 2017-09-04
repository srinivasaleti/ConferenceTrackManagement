package com.tw;

import java.util.ArrayList;
import java.util.List;

//Represents entry point for application
public class ConferenceTrackManagementApp {

    public static void main(String[] args) {
        List<Track> tracksContainer = new ArrayList<>();
        Conference conference = new Conference(tracksContainer);
        ConferenceScheduler conferenceScheduler = new ConferenceScheduler();

        conferenceScheduler.scheduleTalksInto(conference, talks());
    }

    private static List<Talk> talks() {
        List<Talk> talks = new ArrayList<>();
        talks.add(new Talk("Writing Fast Tests Against Enterprise Rails", Duration.minute(60)));
        talks.add(new Talk("Overdoing it in Python", Duration.minute(45)));
        talks.add(new Talk("Lua for the Masses", Duration.minute(30)));
        talks.add(new Talk("Ruby Errors from Mismatched Gem Versions", Duration.minute(45)));
        talks.add(new Talk("Common Ruby Errors", Duration.minute(45)));
        talks.add(new Talk("Rails for Python Developers", Duration.lightning(1)));
        talks.add(new Talk("Communicating Over Distance", Duration.minute(60)));
        talks.add(new Talk("Accounting - Driven Development", Duration.minute(45)));
        talks.add(new Talk("Woah", Duration.minute(30)));
        talks.add(new Talk("Sit Down and Write", Duration.minute(30)));
        talks.add(new Talk("Pair Programming vs Noise", Duration.minute(45)));
        talks.add(new Talk("Rails Magic", Duration.minute(60)));
        talks.add(new Talk("Ruby on Rails: Why We Should Move On", Duration.minute(60)));
        talks.add(new Talk("Clojure Ate Scala (on my project)", Duration.minute(45)));
        talks.add(new Talk("Programming in the Boondocks of Seattle", Duration.minute(30)));
        talks.add(new Talk("Ruby vs. Clojure for Back-End Development", Duration.minute(30)));
        talks.add(new Talk("Ruby on Rails Legacy App Maintenance", Duration.minute(60)));
        talks.add(new Talk("A World Without HackerNews", Duration.minute(30)));
        talks.add(new Talk("User Interface CSS in Rails Apps", Duration.minute(30)));
        return talks;
    }

}
