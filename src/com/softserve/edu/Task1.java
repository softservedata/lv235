package com.softserve.edu;

import java.util.Scanner;

/**
 * @author IRudyk Class Task1.
 */
public abstract class Task1 {
    /**
     * object for input scanner.
     */
    private Scanner scanner;

    /**
     * Default Constructor.
     */
    public Task1() {
        setScanner(new Scanner(System.in));
    }

    /**
     * getScanner.
     *
     * @return scanner
     */
    public Scanner getScanner() {
        return scanner;
    }

    /**
     * setScanner.
     * @param s From Defuault Constructor.
     */
    public void setScanner(final Scanner s) {
        this.scanner = s;
    }

    /**
     * abstract method compute.
     */
    public abstract void compute();

    /**
     * abstract method contunie.
     */
    public abstract void contunie();
}
