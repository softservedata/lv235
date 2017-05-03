package com.softserve.edu.logicTask.task331AB;

import java.util.ArrayList;

/**
 * Class solves the problem task 331A and includes one method.
 *
 * @version 1.1 24.04.2017
 * @author Nazar
 *
 */
public class Task331B {

    /**
     * Some triplet.
     */
    private Triplet triplet;

    /**
     * Fake constructor Task331A documentation comment.
     */
    public Task331B() {
    }

    /**
     * Method logicTask331B solve the problem, if it possible note all triples
     * integers x, y, z for n = x^2 + y^2 + z^2 .
     *
     * @param incomingNumber
     *            Integer entered in console.
     *
     * @return ArrayList<Triplet> list of Triplet.
     */
    public ArrayList<Triplet> findAllTiplet(final int incomingNumber) {
        int x = 1; /* default x number */
        int y = 1; /* default y number */
        int z = 1; /* default z number */

        ArrayList<Triplet> list = new ArrayList<>();
        for (x = 1; x <= incomingNumber; x++) {
            for (y = 1; y <= x; y++) {
                for (z = 1; z <= y; z++) {
                    int tmp = (int) Math.pow(x, 2) + (int) Math.pow(y, 2)
                            + (int) Math.pow(z, 2);
                    if (tmp == incomingNumber) {
                        list.add(new Triplet(x, y, z));
                    }
                }
            }
        }
    return list;
    }
}
