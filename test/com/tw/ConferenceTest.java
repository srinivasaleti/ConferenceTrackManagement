package com.tw;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ConferenceTest {

    @Test
    void addATrackToContainer() {
        List<Track> tracksContainer = mock(List.class);
        Track track = new Track();
        Conference conference = new Conference(tracksContainer);
        conference.addTrack(track);

        verify(tracksContainer).add(track);
    }

    @Test
    void addMultipleTracksToContainer() {
        List<Track> tracksContainer = mock(List.class);
        Track track = new Track();
        Track anotherTrack = new Track();
        Conference conference = new Conference(tracksContainer);
        conference.addTrack(track);
        conference.addTrack(anotherTrack);

        verify(tracksContainer).add(track);
        verify(tracksContainer).add(track);
    }

}
