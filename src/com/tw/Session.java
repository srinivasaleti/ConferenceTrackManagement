package com.tw;

import java.util.ArrayList;
import java.util.List;

//Represents A period devoted to a particular activity.
class Session {

    private final Time startTime;
    private Duration remainingDuration;
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

    void addATalk(Talk talk) {
        if (remainingDuration.isMoreThanOrEqualOf(talk.duration())) {
            this.talksContainer.add(talk);
            changeRemainingTime(talk.duration());
        }
    }

    private void changeRemainingTime(Duration duration) {
        int baseValueOfRemainingDuration = remainingDuration.baseValue() - duration.baseValue();
        this.remainingDuration = Duration.minute(baseValueOfRemainingDuration);
    }

}
