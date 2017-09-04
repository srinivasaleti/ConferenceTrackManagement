package com.tw;

//Represents a formal discussions or negotiations over a period
class Talk {

    private static final String SEPARATOR = " ";

    private Duration duration;
    private Time startTime;
    private String name;

    Talk(String name, Duration duration) {
        this.duration = duration;
        this.name = name;
    }

    Duration duration() {
        return this.duration;
    }

    void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    Time startTime() {
        return this.startTime;
    }

    String representation() {
        return this.startTime.representation() + SEPARATOR + this.name + SEPARATOR + this.duration.representation();
    }

}
