package com.tw;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SessionTest {


    private Session session;
    private List<Talk> talksContainer;

    @Test
    void addJavaTalkToSession() {
        this.talksContainer = mock(List.class);
        Time startTime = new Time(Duration.hour(9), Duration.minute(0), "AM");
        this.session = new Session(this.talksContainer, startTime, Duration.minute(180));
        Duration duration = Duration.minute(60);
        Talk javaTalk = new Talk("Java", duration);

        this.session.addATalk(javaTalk);

        verify(talksContainer).add(javaTalk);
    }

    @Test
    void addPythonTalkToSession() {
        this.talksContainer = mock(List.class);
        Time startTime = new Time(Duration.hour(9), Duration.minute(0), "AM");
        this.session = new Session(this.talksContainer, startTime, Duration.minute(180));
        Duration pythonTalkDuration = Duration.lightning(5);
        String python = "Python";
        Talk pythonTalk = new Talk(python, pythonTalkDuration);

        this.session.addATalk(pythonTalk);

        verify(this.talksContainer).add(pythonTalk);
    }

    @Test
    void changeStartTimeOfTalk() {
        this.talksContainer = new ArrayList<>();
        Time startTime = new Time(Duration.hour(9), Duration.minute(0), "AM");
        this.session = new Session(this.talksContainer, startTime, Duration.minute(180));
        Talk javaTalk = mock(Talk.class);

        when(javaTalk.duration()).thenReturn(Duration.minute(60));
        this.session.addATalk(javaTalk);

        verify(javaTalk).setStartTime(startTime);
    }

    @Test
    void representationSession() {
        this.talksContainer = new ArrayList<>();
        Time startTime = new Time(Duration.hour(9), Duration.minute(0), "AM");
        this.session = new Session(this.talksContainer, startTime, Duration.minute(180));
        Duration duration = Duration.minute(60);
        Talk javaTalk = new Talk("Java", duration);
        String LINE_SEPARATOR = "\n";
        this.session.addATalk(javaTalk);

        assertEquals(javaTalk.representation() + LINE_SEPARATOR, this.session.representation());
    }

    @Test
    void sessionHasTimeOfThirtyMinutes() {
        this.talksContainer = new ArrayList<>();
        Time startTime = new Time(Duration.hour(9), Duration.minute(0), "AM");
        this.session = new Session(this.talksContainer, startTime, Duration.minute(180));

        assertTrue(session.hasDurationOf(Duration.minute(30)));
    }

    @Test
    void sessionDoNotHaveTimeOfThirtyMinutes() {
        this.talksContainer = new ArrayList<>();
        Time startTime = new Time(Duration.hour(9), Duration.minute(0), "AM");
        this.session = new Session(this.talksContainer, startTime, Duration.minute(10));

        assertFalse(session.hasDurationOf(Duration.minute(30)));
    }

}
