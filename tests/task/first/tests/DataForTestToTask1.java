package task.first.tests;

/**
 * Class contain data for TestToTask1.
 * @author IRudyk
 */
public final class DataForTestToTask1 {

    /**
     * private constructor for utility class.
     */
    private DataForTestToTask1() { }

    /**
     * Data to testPositiveResult1().
     */
    public static final DataModelForTestToTask1 DATA_TO_POSITIVE_RESULT_1
                         = new DataModelForTestToTask1(9, 4000045, 6);

    /**
     * Data to testPositiveResult2().
     */
    public static final DataModelForTestToTask1 DATA_TO_POSITIVE_RESULT_2
                         = new DataModelForTestToTask1(16, 2365, 4);

    /**
     * Data to testMTooBig().
     */
    public static final DataModelForTestToTask1 DATA_TO_TEST_M_TOO_BIG
                         = new DataModelForTestToTask1(10000, 6);

    /**
     * Data to testIsNNotNatural().
     */
    public static final DataModelForTestToTask1 DATA_TO_N_NOT_NATURAL
                         = new DataModelForTestToTask1(-1, 325657);

    /**
     * Data to testIsMNotNatural().
     */
    public static final DataModelForTestToTask1 DATA_TO_M_NOT_NATURAL
                         = new DataModelForTestToTask1(3417, -1);
}
