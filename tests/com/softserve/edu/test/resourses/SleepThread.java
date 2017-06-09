package com.softserve.edu.test.resourses;



/**
 * Class for sllep main thread.
 * @author Ivan
 * must be delleted.
 */
public final class SleepThread {

    /**
     * Emplicid wait time.
     */
    private static final int CONVERT_TIME_FOR_WAIT = 1000;

    /**
     * private constructor.
     */
    private SleepThread() { }

    /**
     * Sleep thread.
     * @param countOfSecond time sleep.
     */
    public static void sleep(final int countOfSecond) {
        try {
            Thread.sleep(countOfSecond * CONVERT_TIME_FOR_WAIT);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
