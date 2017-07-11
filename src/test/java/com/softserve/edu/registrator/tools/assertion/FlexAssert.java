package com.softserve.edu.registrator.tools.assertion;

import org.testng.Assert;

import com.softserve.edu.registrator.tools.logs.ReporterWrapper;

public final class FlexAssert {
    private final String APPEND_TEXT = "\nDescription: %s";

    private static volatile FlexAssert instance = null;
    //
    private boolean summaryResult;
    private StringBuilder summaryDescription;

    private FlexAssert() {
        init();
    }

    private void init() {
        this.summaryResult = true;
        this.summaryDescription = new StringBuilder();
    }

    private static FlexAssert get() {
        if (instance == null) {
            synchronized (FlexAssert.class) {
                if (instance == null) {
                    instance = new FlexAssert();
                }
            }
        }
        return instance;
    }

    private boolean getPassed() {
        return summaryResult;
    }

    private String getSummaryDescription() {
        return summaryDescription.toString();
    }

    private void verify(boolean pass, String errorText) {
        System.out.println("\t+++ pass = " + pass + "  errorText = " + errorText);
        summaryResult = summaryResult && pass;
        if (!pass) {
            ReporterWrapper.get().error(errorText);
            ReporterWrapper.get().addSourceCode();
            ReporterWrapper.get().addScreenShot();
            addWarning(errorText);
        }
    }

    private void addWarning(String warningText) {
        summaryDescription.append(String.format(APPEND_TEXT, warningText));
    }

    public static void assertEquals(String actual, String expected) {
        try {
            Assert.assertEquals(actual, expected);
        } catch (AssertionError e) {
            // TODO get Stack Trace
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            for (int i = 0; i < stackTrace.length; i++) {
                System.out.println("\nClass: " + stackTrace[i].getClassName());
                System.out.println("Method: " + stackTrace[i].getMethodName());
                System.out.println("Line: " + stackTrace[i].getLineNumber());
                System.out.println("ALL: " + stackTrace[i].toString());
            }
            get().verify(actual.equals(expected), e.toString());
        }
    }

    public static void assertTrue(boolean condition) {
        try {
            Assert.assertTrue(condition);
        } catch (AssertionError e) {
            // TODO get Stack Trace
            get().verify(condition, e.toString());
        }
    }

    public static void assertAll() {
        instance = get();
        boolean result = instance.getPassed();
        String description = instance.getSummaryDescription();
        instance.init();
        Assert.assertTrue(result, description);
    }

}
