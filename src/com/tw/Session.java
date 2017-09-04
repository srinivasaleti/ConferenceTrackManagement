package com.tw;

import java.util.ArrayList;
import java.util.List;

//Represents A period devoted to a particular activity.
class Session {

    private static final String LINE_SEPARATOR = "\n";

    private Time startTime;
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
            talk.setStartTime(startTime);
            this.talksContainer.add(talk);
            this.startTime = startTime.timeAfter(talk.duration());
            changeRemainingTime(talk.duration());
        }
    }

    private void changeRemainingTime(Duration duration) {
        int baseValueOfRemainingDuration = remainingDuration.baseValue() - duration.baseValue();
        this.remainingDuration = Duration.minute(baseValueOfRemainingDuration);
    }

    String representation() {
        StringBuilder result = new StringBuilder();
        for (Talk talk : this.talksContainer) {
            result.append(talk.representation()).append(LINE_SEPARATOR);
        }
        return result.toString();
    }

    boolean hasTimeOf(Duration duration) {
        return false;
    }

}
