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
 * @version 1.1 24.04.2017
 * @author Nazar
 */
public class Couple {
    /**
     * Constructor without parameters.
     */
    Couple() {
    }
/**
 * @param x number of couple.
 * @param y number of couple.
 */
    public Couple(int x, int y) {
        if (x < y) {
            int tmp = x;
            x = y;
            y = tmp;
        }
        this.x = x;
        this.y = y;
    }

    /** default x number. */
    private int x;
    /** default y number. */
    private int y;
    /**
     * @return part of couple(x, y).
     */
    public int getX() {
        return x;
    }
    /**
     * @return part of couple(x, y).
     */
    public int getY() {
        return y;
    }
    /**
     * @param x
     *            part of couple(x, y).
     */
    public void setX(final int x) {
        this.x = x;
    }
    /**
     * @param y
     *            part of couple(x, y).
     */
    public void setY(final int y) {
        this.y = y;
    }
    /**
     * @return
     *          return true if Couple is empty.
     */
    public boolean isEmpty() {
        if (x == 0 && y == 0) {
            return true;
        }
        return false;
    }
    /**
     * I need Override to equals.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }
    /**
     * I need Override to equals.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Couple other = (Couple) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }
    /**
     * I need Override to String.
     */
    @Override
    public String toString() {
        return "Couple: x=" + x + ", y=" + y + ";";
    }
}
