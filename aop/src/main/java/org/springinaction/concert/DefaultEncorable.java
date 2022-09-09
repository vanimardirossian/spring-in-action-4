package org.springinaction.concert;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultEncorable implements Encorable {

    private static final Logger log = LoggerFactory.getLogger(DefaultEncorable.class);

    @Override
    public void performEncore() {
        log.info("Default encoreable");
    }

}
