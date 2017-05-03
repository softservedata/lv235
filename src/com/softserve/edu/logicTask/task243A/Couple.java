/*@(#)Example.java 1.00 21/04/2017
 *
 * Copyright (c) 1993-2017 Softserve.academy, Inc.
 *
 * This software is the confidential and proprietary information of Softserve.
 */

/**
 *  Package for training.
 */
package com.softserve.edu.logicTask.task243A;

/**
 * Class solves the problem task 243A.
 *
 * @version 1.1 24.04.2017
 * @author Nazar
 *
 */
public class Couple {

/**
 * @param x first number of triplet.
 * @param y first number of triplet.
 */
    public Couple(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    /** default x number. */
    private int x = 1;
    /** default y number. */
    private int y = 1;

    /**
     *
     * @return part of triplet(x, y).
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @return part of triplet(x, y, z).
     */
    public int getY() {
        return y;
    }

    /**
     *
     * @param x
     *            part of triplet(x, y, z).
     */
    public void setX(final int x) {
        this.x = x;
    }

    /**
     *
     * @param y
     *            part of triplet(x, y, z).
     */
    public void setY(final int y) {
        this.y = y;
    }

    /**
     * I need Override to String.
     */
    @Override
    public String toString() {
        return "Couple x=" + x + ", y=" + y + ";";
    }
}
