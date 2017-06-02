package com.softserve.edu.test.resourses;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class FileHelper {
    
    private static final String TIME_TEMPLATE = "yyyy-MM-dd_HH-mm-ss";
    
    private FileHelper() { }    
    
    public static BufferedImage takeScreenShot(WebDriver driver) {
        byte[] img = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        BufferedImage brImage = null;
        try {
            brImage = ImageIO.read(new ByteArrayInputStream(img));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return brImage;
    }
    
    public static void saveScreenShot(File outputFile, String path, String name) {
        try {
            FileUtils.copyFile(outputFile, new File("./TestResults/" + path + "_screenshot.png"));
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

    public static void takeAndSaveScreenShot(WebDriver driver, String folderName, String name) {
        File outputfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(outputfile, new File("./TestResults/" + folderName 
                    +"/"+ name + "_screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    
}
