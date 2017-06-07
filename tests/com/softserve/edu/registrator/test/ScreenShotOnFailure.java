package com.softserve.edu.registrator.test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * */
public class ScreenShotOnFailure implements MethodRule {
	/**
	 * WebDriver instance.
	 * */
	private WebDriver driver;
	/**
	 * Constant for time template for screenshot filename.
	 * */
	private static final String TIME_TEMPLATE = "yyyy-MM-dd_HH-mm-ss";

	/**
	 * Constructor with WebDriver.
	 * */
	public ScreenShotOnFailure(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * @return statement
	 * @param FrameworkMethod
	 *            frameworkMethod
	 * @param Object
	 *            object
	 * @param Statement
	 *            statement
	 * */
	public Statement apply(final Statement statement,
			final FrameworkMethod frameworkMethod, final Object o) {
		return new Statement() {
			@Override
			public void evaluate() throws Throwable {
				try {
					statement.evaluate();
				} catch (Throwable t) {
					captureScreenShot(frameworkMethod.getName());
					throw t;
				}
			}

			public void captureScreenShot(String fileName) throws IOException {
				File scrFile = ((TakesScreenshot) driver)
						.getScreenshotAs(OutputType.FILE);
				fileName += " "
						+ new SimpleDateFormat(TIME_TEMPLATE)
								.format(new Date());
				File targetFile = new File("screenshots/" + fileName + ".png");
				FileUtils.copyFile(scrFile, targetFile);
			}
		};
	}
}
