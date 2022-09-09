package org.springinaction.soundsystem;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class TrackCounter {
    private final Map<Integer, Integer> trackCounts = new HashMap<>();

    @Pointcut("execution(* org.springinaction.soundsystem.CompactDisc.playTrack(int)) && args(trackNumber)")
    public void trackPlayed(int trackNumber) {
    }

    @Before(value = "trackPlayed(trackNumber)", argNames = "trackNumber")
    public void countTrack(int trackNumber) {
        int currentCount = getPlayCount(trackNumber);
        trackCounts.put(trackNumber, currentCount + 1);
    }

    private int getPlayCount(int trackNumber) {
        return trackCounts.getOrDefault(trackNumber, 0);
    }

}
