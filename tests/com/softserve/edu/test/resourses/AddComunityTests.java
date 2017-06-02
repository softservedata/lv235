package com.softserve.edu.test.resourses;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AddComunityTests {

	private static WebDriver driver;
	private static UserLogin userLogin;
	private static String folderName;
	
	@BeforeClass
	public static void before(){
		System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--lang=en-US");
		Map<String, Object> prefs = new HashMap<String, Object>();
	    prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
	    options.setExperimentalOption("prefs", prefs);
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		userLogin = UserLogin.getUserLogin(driver);
		userLogin.login();
		folderName = FileHelper.createDerectory("AddNewComunity");
	}
	
	@AfterClass
	public static void after(){
	    userLogin.quit();
		driver.quit();
	}
	
	//@Test 
	public void createComunityWithValidData() {
	    String name = "Ternopil";
        String number = "214:35:09:346:45789";
        addComunity(name, number);
        Assert.assertTrue(isPresentComunity(name));
        SleepThread.sleep(2);
        DeletingComunity.getDeletingComunity(driver).deleteComunityOK(name);
	}
	
    //Test 
    public void createComunityWithEmptyNumber() {
        String name = "Kyiv";
        String number = "";
        addComunity(name, number);
        Assert.assertTrue(isPresentComunity(name));
        SleepThread.sleep(2);
        DeletingComunity.getDeletingComunity(driver).deleteComunityOK(name);
    }
    
    //@Test 
    public void createComunityWithInvalidNumber() {
        String name = "Odessa";
        String number = "123";
        addComunity(name, number);
        Assert.assertTrue(isPresentErrorLabel("Невірний формат"));
        SleepThread.sleep(2);
    }
    
    //@Test 
    public void createComunityWithUsedNameEmptyNumber() {
        String name = "Lviv";
        String number = "";
        addComunity(name, number);
        Assert.assertTrue(isPresentErrorLabel("Підклас з вказаним іменем вже існує"));
        SleepThread.sleep(2);
    }
    
    //@Test 
    public void createComunityWithUsedNameValidNumber() {
        String name = "Lviv";
        String number = "000:25:09:376:40009";
        addComunity(name, number);
        Assert.assertTrue(isPresentErrorLabel("Підклас з вказаним іменем вже існує"));
        SleepThread.sleep(2);
    }
    
    //@Test 
    public void createComunityWithUsedNameInvalidNumber() {
        String name = "Lviv";
        String number = "123";
        addComunity(name, number);
        Assert.assertTrue(isPresentErrorLabel("Підклас з вказаним іменем вже існує") &&
                isPresentErrorLabel("Невірний формат"));
        SleepThread.sleep(2);
    }
    
    //@Test 
    public void IsPresentErrorMessageNameIsEmpty() {
        String name = "";
        String number = "123";
        addComunity(name, number);
        Assert.assertEquals("Please fill out this field.",
                driver.switchTo().activeElement().getAttribute("validationMessage"));
        SleepThread.sleep(2);
    }
    
    
    @Test 
    public void IsPresentErrorMessageNameInvalidNumberEmpty() {
        String name = "/.";
        String number = "";
        File imageFile = addComunity(name, number);
        if(driver.findElements(By.xpath("//form//span")).size()>0){
            Assert.assertTrue(true); 
        } else {
            FileHelper.saveScreenShot(imageFile, folderName, "beforeTest");
            FileHelper.takeAndSaveScreenShot(driver, folderName, "actualResalt");
            Assert.assertTrue(false); 
        }
        SleepThread.sleep(2);
    }
    
    public File addComunity(String name, String number) {
        driver.findElement(By.xpath("//a[contains(@href,'/show-all-communities')]")).click();
        SleepThread.sleep(2);
        
        driver.findElement(By.xpath("//a[contains(@href,'addCommunity')]")).click();
        SleepThread.sleep(2);
        
        driver.findElement(By.name("name")).click();
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys(name);
        SleepThread.sleep(1);
        
        driver.findElement(By.name("registrationNumber")).click();
        driver.findElement(By.name("registrationNumber")).clear();
        driver.findElement(By.name("registrationNumber")).sendKeys(number);
        SleepThread.sleep(1);
        File outputfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        driver.findElement(By.xpath("//input[contains(@type,'submit')]")).click();
        SleepThread.sleep(1);
        return outputfile;
    }
    
    public boolean isPresentErrorLabel(String message) {
        if(driver.findElements(By.xpath("//span[text() = '"+message+"']")).size()>0) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isPresentComunity(String text) {
        if(driver.findElements(By.xpath("//td/a[text() = '"+text+"']")).size()>0) {
            return true;
        } else {
            return false;
        }    
    }
}
