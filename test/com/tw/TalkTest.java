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

}
