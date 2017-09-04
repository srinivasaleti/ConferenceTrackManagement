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

    String representation() {
        return null;
    }

}
