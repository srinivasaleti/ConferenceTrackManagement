package com.tw;

//Represents a formal discussions or negotiations over a period
class Talk {

    private Duration duration;

    Talk(String name, Duration duration) {
        this.duration = duration;
    }

    Duration duration() {
        return this.duration;
    }


}
