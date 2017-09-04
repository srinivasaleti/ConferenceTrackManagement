package com.tw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;

import static org.mockito.Mockito.*;

class ConferenceSchedulerTest {
    private ConferenceScheduler conferenceScheduler;

    @BeforeEach
    void setUp() {
        this.conferenceScheduler = new ConferenceScheduler();
    }

    @Test
    void askSizeOfTalks() {
        List<Talk> talks = mock(List.class);
        Conference conference = mock(Conference.class);
        when(talks.size()).thenReturn(0);
        conferenceScheduler.scheduleTalksInto(conference, talks);

        verify(talks).size();
    }

    @Test
    void askIteratorOnTalks() {
        List<Talk> talks = mock(List.class);
        Iterator<Talk> iterator = mock(Iterator.class);
        Conference conference = mock(Conference.class);

        when(talks.size()).thenReturn(1, 0);
        when(talks.iterator()).thenReturn(iterator);
        when(iterator.hasNext()).thenReturn(false);

        conferenceScheduler.scheduleTalksInto(conference, talks);

        verify(talks, times(1)).iterator();
    }

    @Test
    void askDurationOfTalkToCheckATrackHasSufficientDuration() {
        Talk javaTalk = mock(Talk.class);
        List<Talk> talks = mock(List.class);
        Iterator<Talk> iterator = mock(Iterator.class);
        Conference conference = mock(Conference.class);

        when(talks.size()).thenReturn(1, 0);
        when(talks.iterator()).thenReturn(iterator);
        when(iterator.hasNext()).thenReturn(true,false);
        when(iterator.next()).thenReturn(javaTalk);
        when(javaTalk.duration()).thenReturn(Duration.minute(60));

        conferenceScheduler.scheduleTalksInto(conference, talks);

        verify(javaTalk,times(5)).duration();
    }

    @Test
    void addATrackToConference() {
        List<Talk> talks = mock(List.class);
        Iterator<Talk> iterator = mock(Iterator.class);
        Conference conference = mock(Conference.class);

        when(talks.size()).thenReturn(1, 0);
        when(talks.iterator()).thenReturn(iterator);
        when(iterator.hasNext()).thenReturn(true,false);
        when(iterator.next()).thenReturn(new Talk("Java",Duration.minute(90)));

        conferenceScheduler.scheduleTalksInto(conference, talks);

        verify(conference).addTrack(any(Track.class));
    }

}

