package com.tw;

import java.util.List;

//Represents a formal meeting of people with a shared interest,
class Conference {

    private final List<Track> tracksContainer;

    Conference(List<Track> tracksContainer) {
        this.tracksContainer = tracksContainer;
    }

    void addTrack(Track track) {
        tracksContainer.add(track);
    }

}
