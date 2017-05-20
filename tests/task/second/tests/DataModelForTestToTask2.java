package task.second.tests;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ivan
 * Clas model data for TestToTask2
 */
public final class DataModelForTestToTask2 {
    /**
     * field for expected result.
     */
    private List<Integer> expectedResult;

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
    public DataModelForTestToTask2(final List<Integer> expected,
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
    public DataModelForTestToTask2(final int n, final int m) {
        super();
        expectedResult = new ArrayList<Integer>();
        this.parameterN = n;
        this.parameterM = m;
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

    /**
     * @return parameter m.
     */
    public int getParameterM() {
        return parameterM;
    }

}
