package com.softserve.edu.registrator.tools.exception;

import com.softserve.edu.registrator.tools.logs.ReporterWrapper;

public class ScreenCapturingCustomException extends GeneralCustomException {
    private static final long serialVersionUID = 1L;

    // Classic constructor with a message of error.
    public ScreenCapturingCustomException(String message) {
        super(message);
        performReports();
    }

    public ScreenCapturingCustomException(String message, Throwable e) {
        super(message, e);
        performReports();
    }

    private void performReports() {
        ReporterWrapper.get().addScreenShot();
    }

}