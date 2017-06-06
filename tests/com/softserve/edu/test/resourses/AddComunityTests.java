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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddComunityTests {

	private static WebDriver driver;
	private static UserLogin userLogin;
	private static String folderName;
	
	@BeforeClass
	public static void beforeClass(){
		System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		Map<String, Object> prefs = new HashMap<String, Object>();
	    prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
	    options.setExperimentalOption("prefs", prefs);
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		userLogin = UserLogin.getUserLogin(driver);
		userLogin.login();
		folderName = FileHelper.createDerectory("AddNewComunity");
	}
	
	@Test 
	public void createComunityWithValidData() {
	    String name = "Ternopil";
        String number = "214:35:09:346:45789";
        File screenShot = addComunity(name, number);
        if(!isPresentComunity(name)) {
            String nameFolder = "TestValidData";
            FileHelper.saveBugAttachments(folderName+"/"+nameFolder, screenShot, driver);
            DeletingComunity.getDeletingComunity(driver).deleteComunityIfExistOk(name);
            Assert.fail();
        }
        DeletingComunity.getDeletingComunity(driver).deleteComunityIfExistOk(name);
        SleepThread.sleep(1);
	}
	
    @Test 
    public void createComunityWithValidNameEmptyNumber() {
        String name = "Kyiv";
        String number = "";
        File screenShot = addComunity(name, number);
        if(!isPresentComunity(name)) {
            String nameFolder = "TestValidNameEmptyNumber";
            FileHelper.saveBugAttachments(folderName+"/"+nameFolder, screenShot, driver);
            DeletingComunity.getDeletingComunity(driver).deleteComunityIfExistOk(name);
            Assert.fail();
        }
        DeletingComunity.getDeletingComunity(driver).deleteComunityIfExistOk(name);
        SleepThread.sleep(1);
    }
    
    @Test 
    public void createComunityWithValidNameInvalidNumber() {
        String name = "Odessa";
        String number = "123";
        File screenShot = addComunity(name, number);
        if(!isPresentErrorLabel("Невірний формат")) {
            String nameFolder = "TestValidNameInvalidNumber";
            FileHelper.saveBugAttachments(folderName+"/"+nameFolder, screenShot, driver);
            DeletingComunity.getDeletingComunity(driver).deleteComunityIfExistOk(name);
            Assert.fail();
        }
        DeletingComunity.getDeletingComunity(driver).deleteComunityIfExistOk(name);
        SleepThread.sleep(1);
    }
    
    @Test 
    public void createComunityWithValidNameUsedNumber() {
        String name = "Ivano-Frankivsk";
        String number = "000:25:09:376:40009";
        File screenShot = addComunity(name, number);
        if(driver.findElements(By.xpath("//form//span")).size() != 1) {
            String nameFolder = "TestValidNameUsedNumber";
            FileHelper.saveBugAttachments(folderName+"/"+nameFolder, screenShot, driver);
            DeletingComunity.getDeletingComunity(driver).deleteComunityIfExistOk(name);
            Assert.fail();
        }
        DeletingComunity.getDeletingComunity(driver).deleteComunityIfExistOk(name);
        SleepThread.sleep(1);
    }
    
    @Test 
    public void createComunityWithUsedNameEmptyNumber() {
        String name = "Lviv";
        String number = "";
        File screenShot = addComunity(name, number);
        if(!isPresentErrorLabel("Підклас з вказаним іменем вже існує")) {
            String nameFolder = "TestUsedNameEmptyNumber";
            FileHelper.saveBugAttachments(folderName+"/"+nameFolder, screenShot, driver);
            Assert.fail();
        }
        SleepThread.sleep(1);
    }
    
    @Test 
    public void createComunityWithUsedNameInvalidNumber() {
        String name = "Lviv";
        String number = "123";
        File screenShot = addComunity(name, number);
        if(!isPresentErrorLabel("Підклас з вказаним іменем вже існує") ||
                !isPresentErrorLabel("Невірний формат")) {
            String nameFolder = "TestUsedNameInvalidNumber";
            FileHelper.saveBugAttachments(folderName+"/"+nameFolder, screenShot, driver);
            Assert.fail();
        }
        SleepThread.sleep(1);
    }
    
    @Test 
    public void createComunityWithUsedNameUsedNumber() {
        String name = "Lviv";
        String number = "000:25:09:376:40009";
        File screenShot = addComunity(name, number);
        if(driver.findElements(By.cssSelector("#body span")).size() != 2) {
            String nameFolder = "TestUsedNumberUsedNumber";
            FileHelper.saveBugAttachments(folderName+"/"+nameFolder, screenShot, driver);
            Assert.fail();
        }
        SleepThread.sleep(1);
    }
    
    @Test 
    public void createComunityWithEmptyName() {
        String name = "";
        String number = "123";
        File screenShot = addComunity(name, number);
        if(!driver.switchTo().activeElement().getAttribute("validationMessage")
                .equals("Заповніть це поле.")) {
            FileHelper.saveBugAttachments(folderName+"/TestEmptyName", screenShot, driver);
            DeletingComunity.getDeletingComunity(driver).deleteComunityIfExistOk(name);
            Assert.fail();
        }
        SleepThread.sleep(1);
    }
    
    
    @Test 
    public void createComunityWithInvalidNameEmptyNumber() {
        String name = "/.";
        String number = "";
        File screenShot = addComunity(name, number);
        if(driver.findElements(By.cssSelector("#body span")).size() != 1) {
            String nameFolder = "TestInvalidNameEmptyNumber";
            FileHelper.saveBugAttachments(folderName+"/"+nameFolder, screenShot, driver);
            DeletingComunity.getDeletingComunity(driver).deleteComunityIfExistOk(name);
            Assert.fail();
        }
        SleepThread.sleep(1);
    }
    
    @Test 
    public void createComunityWithInvalidNameInvalidNumber() {
        String name = "/.";
        String number = "123";
        File screenShot = addComunity(name, number);
        if(driver.findElements(By.cssSelector("#body span")).size() != 2) {
            String nameFolder = "TestInvalidNameInvalidNumber";
            FileHelper.saveBugAttachments(folderName+"/"+nameFolder, screenShot, driver);
            DeletingComunity.getDeletingComunity(driver).deleteComunityIfExistOk(name);
            Assert.fail();
        }
        SleepThread.sleep(1);
    }
    
    @Test 
    public void createComunityWithInvalidNameUsedNumber() {
        String name = "#4/^";
        String number = "123:54:67:123:98734";
        File screenShot = addComunity(name, number);
        if(driver.findElements(By.cssSelector("#body span")).size() != 1) {
            String nameFolder = "TestInvalidNameUsedNamber";
            FileHelper.saveBugAttachments(folderName+"/"+nameFolder, screenShot, driver);
            DeletingComunity.getDeletingComunity(driver).deleteComunityIfExistOk(name);
            Assert.fail();
        }
        SleepThread.sleep(1);
    }
    
    @Test 
    public void isEmptyFiledByDefault() {     
        driver.findElement(By.xpath("//a[contains(@href,'/show-all-communities')]")).click();
        File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        driver.findElement(By.cssSelector("a[href= 'addCommunity']")).click();
        SleepThread.sleep(1);
        if(!driver.findElement(By.name("name")).getText().equals("") &&
                !driver.findElement(By.name("registrationNumber")).getText().equals("")) {
            String nameFolder = "TestEmptyFiledByDefault";
            FileHelper.saveBugAttachments(folderName+"/"+nameFolder, screenShot, driver);
            Assert.fail();
        }
        SleepThread.sleep(1);
    }
    
    @Test 
    public void isEmptyFiledAfterCancel() {     
        driver.findElement(By.xpath("//a[contains(@href,'/show-all-communities')]")).click();
        driver.findElement(By.cssSelector("a[href= 'addCommunity']")).click();
        File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        driver.findElement(By.name("name")).sendKeys("Harkiv");
        driver.findElement(By.name("registrationNumber")).sendKeys("111:22:55:666:99999");
        driver.findElement(By.cssSelector("button[type='reset']")).click();
        SleepThread.sleep(2);
        if(!driver.findElement(By.name("name")).getText().equals("") &&
                !driver.findElement(By.name("registrationNumber")).getText().equals("")) {
            String nameFolder = "TestEmptyFiledAfterClear";
            FileHelper.saveBugAttachments(folderName+"/"+nameFolder, screenShot, driver);
            Assert.fail();
        }
        SleepThread.sleep(1);
    }
    
    @AfterClass
    public static void afterClass(){
        userLogin.quit();
        driver.quit();
    }
    
    public File addComunity(String name, String number) {
        
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(driver
             .findElement(By.xpath("//a[contains(@href,'/show-all-communities')]"))));
        
        SleepThread.sleep(1);
        driver.findElement(By.xpath("//a[contains(@href,'/show-all-communities')]")).click();
        
        
        driver.findElement(By.cssSelector("a[href= 'addCommunity']")).click();
        SleepThread.sleep(1);
        
        driver.findElement(By.name("name")).click();
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys(name);
        
        driver.findElement(By.name("registrationNumber")).click();
        driver.findElement(By.name("registrationNumber")).clear();
        driver.findElement(By.name("registrationNumber")).sendKeys(number);
        SleepThread.sleep(1);
        File viewBeforeTestExecute = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        driver.findElement(By.cssSelector("input[type = 'submit']")).click();
        SleepThread.sleep(1);
        return viewBeforeTestExecute;
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
