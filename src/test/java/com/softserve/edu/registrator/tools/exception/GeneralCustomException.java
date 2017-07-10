package com.softserve.edu.registrator.tools.exception;

import com.softserve.edu.registrator.tools.logs.ReporterWrapper;

public class GeneralCustomException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private static final String GENERAL_CUSTOM_EXCEPTION ="GeneralCustomException: %s";

	// Classic constructor with a message of error.
	public GeneralCustomException(String message) {
		super(message);
		performLogging(message);
	}

	public GeneralCustomException(String message, Throwable e) {
		super(message, e);
		performLogging(message);
	}

	private void performLogging(String message) {
		ReporterWrapper.get().error(String.format(GENERAL_CUSTOM_EXCEPTION, message));
	}

}