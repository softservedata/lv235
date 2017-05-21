package com.softserve.edu.logicTask;

import java.util.Scanner;

/**
 * Class to get Scanner singleton and read integer from console.
 *
 * @version 1.1. 24.04.2017
 * @author Nazar
 */
public final class ScannerSingleton {
    /**
     * The class field.
     */
    private static Scanner scanner;

    /**
     * Default constructor ScannerSingleton.
     */
    private ScannerSingleton() {
    }

    /**
     * Creating new Scanner.
     * @return scanner
     */
    public static Scanner getScanner() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }

    /**
     * Scanning integer.
     * @return int scanned from the input
     */
    public static int readInt() {
        return getScanner().nextInt();
    }
}
