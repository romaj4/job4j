package ru.job4j.sql;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class UsageLog4j2 {

    private static final Logger LOG = LogManager.getLogger(UsageLog4j2.class.getName());

    public static void main(String[] args) {
        int version = 1;
        String str = "java";
        LOG.trace("trace message {}", version);
        LOG.debug("debug message {}", str);
        LOG.info("info message {}, {}", version, str);
        LOG.warn("warn message {}", version);
        LOG.error("error message {}", version);
    }
}
