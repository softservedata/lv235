package com.softserve.edu.logicTask.task107;

/**
 * Class solves the problem task 107 and includes one method.
 *
 * @version 1.1 24.04.2017
 * @author Nazar
 *
 */
    public class Task107 {

    /**
     * Fake constructor Task107 documentation comment.
     */
    public Task107() {
    }

    /**
     * constant for the particular case the algorithm program.
     */
    private static final int TWO = 2;

    /**
     * constant for the particular case the algorithm program.
     */
    private static final int THREE = 3;

    /**
     * constant for the particular case the algorithm program.
     */
    private static final int FOUR = 4;

    /**
     * Method logicTask107 solve the problem, to find maximum k,
     *            4^k < m, if integer m > 1.
     *
     * @param incomingNumber
     *            Parameter entered in console.
     *
     * @return -1 if enter incorrect numbers less then 2 or not integer. 0 in
     *         part case, if incoming number 2 or 3. k integer if incomingNumber
     */
    public int logicTask107(final int incomingNumber) {
        int result = 1; /* result - max power of number 4 */
        if (incomingNumber == TWO) {
            return 0;
        } else if (incomingNumber == THREE) {
            return 0;
        } else if (incomingNumber == FOUR) {
            return 0;
        } else if (incomingNumber > FOUR) {
            while ((int) Math.pow(FOUR, result + 1) < incomingNumber) {
                result++;
            }
            return result;
        } else {
            return -1;
        }
    }
}
