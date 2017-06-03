package com.softserve.edu.test.resourses;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class FileHelper {
    
    private static final String TIME_TEMPLATE = "yyyy-MM-dd_HH-mm-ss";
    
    private FileHelper() { }    
    
    public static void saveBugAttachments(String path, File screenShot, WebDriver driver) {
        FileHelper.saveScreenShot(screenShot, path, "beforeTest");
        FileHelper.saveScreenShot(
                   ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE),
                   path, "actualResalt");
    }
    
    public static void saveScreenShot(File outputFile, String path, String name) {
        try {
            FileUtils.copyFile(outputFile, new File("./TestResults/" + path +"/"+ name +"_screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
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
