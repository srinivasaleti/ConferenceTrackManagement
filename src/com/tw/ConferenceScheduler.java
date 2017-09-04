package com.tw;

import java.util.Iterator;
import java.util.List;

//Represents a scheduler which schedules given talks into a conference
class ConferenceScheduler {

    void scheduleTalksInto(Conference conference, List<Talk> talks) {
        while (talks.size() != 0) {
            Track track = new Track();
            addTalksTo(track, talks);
            conference.addTrack(track);
        }
    }

    private void addTalksTo(Track track, List<Talk> talks) {
        for (Iterator<Talk> talkIterator = talks.iterator(); talkIterator.hasNext(); ) {
            Talk talk = talkIterator.next();
            if (track.hasDurationOf(talk.duration())) {
                track.addTalkInASession(talk);
                talkIterator.remove();
            }
        }
    }

}
