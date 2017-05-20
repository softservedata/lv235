package task.third.tests;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ivan
 * Clas model data for TestToTask3
 */
public final class DataModelForTestToTask3 {
    /**
     * field for expected result.
     */
    private List<Integer> expectedResult;

    /**
     * field parametr n.
     */
    private int parameterN;

    /**
     * Constructor with three parameters.
     * @param expected Result.
     * @param n natural number.
     */
    public DataModelForTestToTask3(final List<Integer> expected, final int n) {
        super();
        this.expectedResult = expected;
        this.parameterN = n;
    }

    /**
     * Constructor with two parameters.
     * @param n natural number.
     */
    public DataModelForTestToTask3(final int n) {
        super();
        expectedResult = new ArrayList<Integer>();
        this.parameterN = n;
    }

    /**
     * @return expected result.
     */
    public List<Integer> getExpectedResult() {
        return expectedResult;
    }

    /**
     * @return parameter n.
     */
    public int getParameterN() {
        return parameterN;
    }
}
