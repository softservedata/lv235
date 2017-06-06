package com.softserve.edu.test.resourses;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * Utility class for work with screenShot and file.
 * @author Ivan
 */
public final class FileHelper {

    /**
     * Standart time for named folder with screenshot.
     */
    private static final String TIME_TEMPLATE = "yyyy-MM-dd_HH-mm-ss";

    /**
     * private constructor.
     */
    private FileHelper() { }

    /**
     * methot for saving screenShits if bug is present.
     * @param path folder to save screenShot.
     * @param screenShot before test test execute.
     * @param driver WebDriver.
     */
    public static void saveBugAttachments(
            final String path, final File screenShot, final WebDriver driver) {
        FileHelper.saveScreenShot(screenShot, path, "beforeTest");
        FileHelper.saveScreenShot(
                   ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE),
                   path, "actualResalt");
    }

    /**
     * method saving screenShot in before created folder.
     * @param screenShot image for saving.
     * @param path where screenShot will be saved.
     * @param name Image name.
     */
    public static void saveScreenShot(
            final File screenShot, final String path, final String name) {
        try {
            FileUtils.copyFile(screenShot, new File(
                    "./TestResults/" + path + "/" + name + "_screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * method create new derectory.
     * @param testCaseName
     * @return
     */
    public static String createDerectory(String testCaseName) {
        String nameDir = testCaseName + new SimpleDateFormat(TIME_TEMPLATE)
                .format(new Date());
        File theDir = new File("./TestResults/"+nameDir);
        if (!theDir.exists()) {
            try {
                theDir.mkdir();
            } 
            catch(SecurityException se){
                System.out.println("folder is not created");
            }
        }
        return nameDir;
    }

}
