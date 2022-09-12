package org.springinaction.spittr.data;

import org.springinaction.spittr.domain.Spitter;

public interface SpitterRepository {
    Spitter save(Spitter spitter);
    Spitter findByUsername(String username);
}
