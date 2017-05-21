/*@(#)Example.java 1.00 21/04/2017
 *
 * Copyright (c) 1993-2017 Softserve.academy, Inc.
 *
 * This software is the confidential and proprietary information of Softserve.
 */

/**
 *  Package for training.
 */
package com.softserve.edu.logicTask.task331AB;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class solves the problem task 331A and 331B.
 *
 * @version 1.1 24.04.2017
 * @author Nazar
 *
 */
public final class Triplet {

    /**
     * Ststic class field - counter Triplets.
     */
    private static int count  = 0;

/**
 * @param x number of triplet.
 * @param y number of triplet.
 * @param z number of triplet.
 */
    public Triplet(final int x, final int y, final int z) {
        List<Integer> list = new ArrayList<>();
        list.add(x);
        list.add(y);
        list.add(z);
        Collections.sort(list, Collections.reverseOrder());
        this.x = list.get(0);
        this.y = list.get(1);
        this.z = list.get(2);
/*        this.x = x;
        this.y = y;
        this.z = z;*/
    }

    /** default x number. */
    private int x;

    /** default y number. */
    private int y;

    /** default y number. */
    private int z;

    /**
     * @return part of triplet(x, y, z).
     */
    public int getX() {
        return x;
    }
    /**
     * @return part of triplet(x, y, z).
     */
    public int getY() {
        return y;
    }
    /**
     * @return part of triplet(x, y, z).
     */
    public int getZ() {
        return z;
    }
    /**
     * @param x
     *            part of triplet(x, y, z).
     */
    public void setX(final int x) {
        this.x = x;
    }
    /**
     * @param y
     *            part of triplet(x, y, z).
     */
    public void setY(final int y) {
        this.y = y;
    }
    /**
     * @param z
     *            part of triplet(x, y, z).
     */
    public void setZ(final int z) {
        this.z = z;
    }
    /**
     * To compare of Triplet objects.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        result = prime * result + z;
        return result;
    }
    /**
     * To compare of Triplet objects.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Triplet other = (Triplet) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        if (z != other.z)
            return false;
        return true;
    }

    /**
     * Triplet  parse to String.
     */
    @Override
    public String toString() {
        count++;
        return  count + ")" + " Tiplet: x=" + x + ", y=" + y + ", z=" + z + ";";
    }
}
