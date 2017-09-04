package com.tw;

import java.util.ArrayList;
import java.util.List;

//Represents A period devoted to a particular activity.
class Session {

    private final Time startTime;
    private final Duration remainingDuration;
    private final List<Talk> talksContainer;

    Session(List<Talk> talksContainer, Time startTime, Duration remainingDuration) {
        this.startTime = startTime;
        this.remainingDuration = remainingDuration;
        if (talksContainer == null) {
            this.talksContainer = new ArrayList<>();
        } else {
            this.talksContainer = talksContainer;
        }
    }

    void addATalk(Talk talk)
    {
        this.talksContainer.add(talk);
    }

}
