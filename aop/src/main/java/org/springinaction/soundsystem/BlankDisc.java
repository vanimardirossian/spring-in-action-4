package org.springinaction.soundsystem;

import java.util.List;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlankDisc implements CompactDisc {

    private static final Logger log = LoggerFactory.getLogger(BlankDisc.class);


    private String title;
    private String artist;
    private List<String> tracks;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }

    @Override
    public void play() {
        log.info("Playing {} by {}", title, artist);
        IntStream.range(0, tracks.size()).forEach(this::playTrack);
    }

    @Override
    public void playTrack(int track) {
        log.info("-Track: {}", tracks.get(track));
    }

}
