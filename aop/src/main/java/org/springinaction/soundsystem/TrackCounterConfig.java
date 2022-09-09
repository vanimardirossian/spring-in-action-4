package org.springinaction.soundsystem;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class TrackCounterConfig {

    @Bean
    public CompactDisc sgtPeppers() {
        BlankDisc blankDisc = new BlankDisc();
        blankDisc.setTitle("Sgt. Pepper's Lonely Heats Club Band");
        blankDisc.setArtist("The Beatles");
        List<String> tracks = Arrays.asList(
            "Sgt. Pepper's Lonely Heats Club Band",
            "With a Little Help From My Friends",
            "Lucy in the Sky with Diamonds",
            "Getting Better",
            "Fixing a Hole"
        );
        blankDisc.setTracks(tracks);
        return blankDisc;
    }

    @Bean
    public TrackCounter trackCounter() {
        return new TrackCounter();
    }

}
