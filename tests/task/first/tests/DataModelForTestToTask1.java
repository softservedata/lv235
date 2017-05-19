package task.first.tests;

/**
 * @author Ivan
 * Clas model data for TestToTask1
 */
public final class DataModelForTestToTask1 {
    /**
     * field for expected result.
     */
    private int expectedResult;

    /**
     * field parametr n.
     */
    private int parameterN;

    /**
     * field parametr m.
     */
    private int parameterM;


    /**
     * Constructor with three parameters.
     * @param expected Result.
     * @param n natural number.
     * @param m natural number.
     */
    public DataModelForTestToTask1(final int expected,
                                  final int n, final int m) {
        super();
        this.expectedResult = expected;
        this.parameterN = n;
        this.parameterM = m;
    }

    /**
     * Constructor with two parameters.
     * @param n natural number.
     * @param m natural number.
     */
    public DataModelForTestToTask1(final int n, final int m) {
        super();
        this.parameterN = n;
        this.parameterM = m;
    }

    /**
     * @return expected result.
     */
    public int getExpectedResult() {
        return expectedResult;
    }

    /**
     * @return parameter n.
     */
    public int getParameterN() {
        return parameterN;
    }

    /**
     * @return parameter m.
     */
    public int getParameterM() {
        return parameterM;
    }

}
