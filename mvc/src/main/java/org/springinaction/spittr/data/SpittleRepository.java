package org.springinaction.spittr.data;

import java.util.List;

import org.springinaction.spittr.domain.Spittle;

public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);
    Spittle findOne(long spittleId);
}
