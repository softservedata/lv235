package com.softserve.edu.tests.task3;

import java.util.Arrays;

/**
 * Class contain data for TestToTask3.
 * @author IRudyk
 */
public final class DataForTestToTask3 {

    /**
     * private constructor for utility class.
     */
    private DataForTestToTask3() { }

    /**
     * data to test Result is found.
     */
    public static final DataModelForTestToTask3 RESULTS_IS_FOUND =
            new DataModelForTestToTask3(Arrays.asList(
                new Integer[] {3, 7, 31, 127, 2047, 8191}), 15458);

    /**
     * data to test Result is not found.
     */
    public static final DataModelForTestToTask3 RESULTS_IS_NOT_FOUND =
            new DataModelForTestToTask3(3);
}
