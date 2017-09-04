package com.tw;

import java.util.List;

//Represents a formal meeting of people with a shared interest,
class Conference {

    private static final String LINE_SEPARATOR = "\n";

    private final List<Track> tracksContainer;

    Conference(List<Track> tracksContainer) {
        this.tracksContainer = tracksContainer;
    }

    void addTrack(Track track) {
        tracksContainer.add(track);
    }

    String representation() {
        StringBuilder result = new StringBuilder();
        for (Track track : tracksContainer) {
            result.append(track.representation()).append(LINE_SEPARATOR);
        }
        return result.toString();
    }

}
