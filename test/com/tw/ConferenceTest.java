package com.tw;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

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

    @Test
    void askRepresentationOfATrackToGetRepresentationOfConference() {
        Track firstTrack = mock(Track.class);
        List<Track> tracksContainer = new ArrayList<>();
        Conference conference = new Conference(tracksContainer);
        String firstTrackRepresentation = "FirstTrack Representation";
        when(firstTrack.representation()).thenReturn(firstTrackRepresentation);

        conference.addTrack(firstTrack);
        conference.representation();

        verify(firstTrack).representation();
    }

    @Test
    void askRepresentationOfEveryTrackInContainerToGetRepresentationOfConference() {
        Track firstTrack = mock(Track.class);
        Track secondTrack = mock(Track.class);
        List<Track> tracksContainer = new ArrayList<>();
        Conference conference = new Conference(tracksContainer);
        String firstTrackRepresentation = "FirstTrack Representation";
        String secondTrackRepresentation = "SecondTrack Representation";

        when(firstTrack.representation()).thenReturn(firstTrackRepresentation);
        when(secondTrack.representation()).thenReturn(secondTrackRepresentation);
        conference.addTrack(firstTrack);
        conference.addTrack(secondTrack);
        conference.representation();

        verify(firstTrack).representation();
        verify(secondTrack).representation();
    }

    @Test
    void expectedRepresentationOfConference() {
        Track firstTrack = mock(Track.class);
        Track secondTrack = mock(Track.class);
        List<Track> tracksContainer = new ArrayList<>();
        Conference conference = new Conference(tracksContainer);
        String LINE_SEPARATOR = "\n";
        String firstTrackRepresentation = "FirstTrack Representation";
        String secondTrackRepresentation = "SecondTrack Representation";

        when(firstTrack.representation()).thenReturn(firstTrackRepresentation);
        when(secondTrack.representation()).thenReturn(secondTrackRepresentation);
        conference.addTrack(firstTrack);
        conference.addTrack(secondTrack);

        assertEquals(firstTrackRepresentation + LINE_SEPARATOR + secondTrackRepresentation + LINE_SEPARATOR, conference.representation());
    }

}
