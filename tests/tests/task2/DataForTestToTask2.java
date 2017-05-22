package tests.task2;

import java.util.Arrays;

/**
 * Class contain data for TestToTask2.
 * @author IRudyk
 */
public final class DataForTestToTask2 {

    /**
     * private constructor for utility class.
     */
    private DataForTestToTask2() { }

    /**
     * Data to ResultIsFound().
     */
    public static final DataModelForTestToTask2 DATA_TO_RESULT_IS_FOUND
                 = new DataModelForTestToTask2(Arrays.asList(
                       new Integer[] {10025, 20050, 30075, 40100}), 2005, 25);

    /**
     * Data to ResultIsNotFound().
     */
    public static final DataModelForTestToTask2 DATA_TO_RESULT_IS_NOT_FOUND
                 = new DataModelForTestToTask2(1243, 1);

    /**
     * Data to IsNotNaturalN.
     */
    public static final DataModelForTestToTask2 DATA_TO_IS_NOT_NATURAL_N
                 = new DataModelForTestToTask2(-1, 325);

    /**
     * Data to IsNotNaturalM.
     */
    public static final DataModelForTestToTask2 DATA_TO_IS_NOT_NATURAL_M
                 = new DataModelForTestToTask2(587, -1);
}
