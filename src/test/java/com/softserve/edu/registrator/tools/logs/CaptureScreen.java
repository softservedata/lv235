package com.softserve.edu.registrator.tools.logs;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.softserve.edu.registrator.pages.Application;
import com.softserve.edu.registrator.tools.exception.GeneralCustomException;

public class CaptureScreen {

    private final String FILE_SUFFIX = "_CaptureScreenImage.png";
    private final String DEFAULT_DIRECTORY = "./test-output";
    private final String MAVEN_DIRECTORY = "surefire.reports.directory";
    private final String SLASH = "/";
    private final String FAILED_TO_CREATE = "Failed to create screenshot: %s";

    private String getOutputDirectory() {
        String outputDirectory = System.getProperty(MAVEN_DIRECTORY);
        if ((outputDirectory == null) || (outputDirectory.isEmpty())) {
            outputDirectory = DEFAULT_DIRECTORY;
        }
        // System.out.println("\t+++++outputDirectory = " + outputDirectory);
        return outputDirectory + SLASH;
    }

    private String getRelativePathFileName() {
        return getOutputDirectory() + CurrentTime.get() + FILE_SUFFIX;
    }

    private String getAbsolutePathFileName() {
        //System.out.println("\t\t\t+++ getAbsolutePathFileName() = " 
        //        + CaptureScreen.class.getResource("/").getPath().substring(1)
        //        + getRelativePathFileName());
        return CaptureScreen.class.getResource(SLASH).getPath().substring(1) + getRelativePathFileName();
    }

    /**
     * @return Absolute path of filename.
     */
    public String takeScreen() {
        String absolutePathFileName = getAbsolutePathFileName();
        File srcFile = ((TakesScreenshot) Application.get().getBrowser())
                .getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File(absolutePathFileName));
        } catch (IOException e) {
            throw new GeneralCustomException(String.format(FAILED_TO_CREATE, absolutePathFileName), e);
        }
        return absolutePathFileName;
    }

}
