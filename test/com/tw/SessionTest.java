package com.tw;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
    void canNotAddATalkIfThereIsNoRemainingTimeInSession() {
        this.talksContainer = mock(List.class);
        Time startTime = new Time(Duration.hour(9), Duration.minute(0), "AM");
        this.session = new Session(this.talksContainer, startTime, Duration.minute(180));
        Duration javaTalkDuration = Duration.minute(180);
        Duration pythonTalkDuration = Duration.lightning(5);
        String java = "Java";
        String python = "Python";
        Talk javaTalk = new Talk(java, javaTalkDuration);
        Talk pythonTalk = new Talk(python, pythonTalkDuration);

        this.session.addATalk(javaTalk);
        this.session.addATalk(pythonTalk);

        verify(this.talksContainer).add(javaTalk);
        verify(this.talksContainer, never()).add(pythonTalk);
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

}
