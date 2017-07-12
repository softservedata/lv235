package com.softserve.edu.registrator.tools.assertion;

import org.testng.Assert;

import com.softserve.edu.registrator.tools.logs.ReporterWrapper;

public final class FlexAssert {
    private final String APPEND_TEXT = "\nDescription: %s";
    private final String APPEND_STACK_TRACE_ELEMENT = "\nat %s";
    private static final String ERROR_ASSERT_MESSAGE = "\n%s%s";
    private static final String NEW_LINE = "\n";
    private static final String BREAK_LINE = "<BR>";

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
        //System.out.println("\t+++ pass = " + pass + "  errorText = " + errorText);
        summaryResult = summaryResult && pass;
        if (!pass) {
            ReporterWrapper.get().error(errorText.replaceAll(NEW_LINE, BREAK_LINE));
            ReporterWrapper.get().addSourceCode();
            ReporterWrapper.get().addScreenShot();
            addWarning(errorText);
        }
    }

    private void addWarning(String warningText) {
        summaryDescription.append(String.format(APPEND_TEXT, warningText));
    }

    private String getStackTrace() {
        StringBuilder stackTrace = new StringBuilder();
        // get Stack Trace
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        for (int i = 3; i < stackTraceElements.length; i++) {
            //System.out.println("\nClass: " + stackTraceElements[i].getClassName());
            //System.out.println("Method: " + stackTraceElements[i].getMethodName());
            //System.out.println("Line: " + stackTraceElements[i].getLineNumber());
            //System.out.println("ALL: " + stackTraceElements[i].toString());
            stackTrace.append(String.format(APPEND_STACK_TRACE_ELEMENT,
                    stackTraceElements[i].toString()));
        }
        return stackTrace.toString();
    }

    public static void assertEquals(String actual, String expected) {
        try {
            Assert.assertEquals(actual, expected);
        } catch (AssertionError e) {
            get().verify(actual.equals(expected), String.format(ERROR_ASSERT_MESSAGE,
                    e.toString(), get().getStackTrace()));
        }
    }

    public static void assertTrue(boolean condition) {
        try {
            Assert.assertTrue(condition);
        } catch (AssertionError e) {
            get().verify(condition, String.format(ERROR_ASSERT_MESSAGE,
                    e.toString(), get().getStackTrace()));
        }
    }

    public static void assertAll() {
        instance = get();
        boolean result = instance.getPassed();
        String description = instance.getSummaryDescription();
        //System.out.println("\n++++++++++\n" + description + "\n++++++++++\n");
        instance.init();
        Assert.assertTrue(result, description);
    }

}
