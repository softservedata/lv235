package com.softserve.edu.registrator.tools.logs;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class CurrentTime {

    private static final String TIME_TEMPLATE = "yyyy_MM_dd_HH-mm-ss";

    private CurrentTime() {
    }

    public static String get() {
        return new SimpleDateFormat(TIME_TEMPLATE).format(new Date());
    }

    public static String get(String template) {
        return new SimpleDateFormat(template).format(new Date());
    }

}
